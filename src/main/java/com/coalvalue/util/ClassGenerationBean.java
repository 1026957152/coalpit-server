package com.coalvalue.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Peter Xu on 01/05/2015.
 */
@Component
public class ClassGenerationBean {

    @Autowired
    private DataSource ds;

    @Autowired
    private FreeMarkerUtilBean freeMarkerUtilBean;

    @Autowired
    private ApplicationContext ctx;

    private Map<String, String> mysql2JavaTypeMap;

    private Set<String> commonColumns;

    private Set<String> commonImports;

    private List<TableDef> tableDefList;

    private String domainPkg = "com.coalvalue.domain";

    private String repositoryPkg = "com.coalvalue.repository";

    private String servicePkg = "com.coalvalue.service";

    private boolean overrideFile = false;


    public ClassGenerationBean() {
        initMySql2JavaTypeMap();
        initCommonColumnSet();
        initCommonImportSet();
    }

    private void initCommonColumnSet() {
        this.commonColumns = new HashSet<>();
        commonColumns.add("ID");
        commonColumns.add("CREATE_BY");
        commonColumns.add("MODIFY_BY");
        commonColumns.add("CREATE_DATE");
        commonColumns.add("MODIFY_DATE");
        commonColumns.add("VERSION");
    }

    private void initCommonImportSet() {
        this.commonImports = new HashSet<>();
        commonImports.add("import javax.persistence.Column;");
        commonImports.add("import javax.persistence.Entity;");
        commonImports.add("import javax.persistence.Table;");
    }

    private void initMySql2JavaTypeMap() {
        this.mysql2JavaTypeMap = new HashMap<>();
        mysql2JavaTypeMap.put("CHAR", "String");
        mysql2JavaTypeMap.put("VARCHAR", "String");
        mysql2JavaTypeMap.put("TEXT", "String");
        mysql2JavaTypeMap.put("INT", "Integer");
        mysql2JavaTypeMap.put("BIGINT", "Integer");
        mysql2JavaTypeMap.put("DATE", "java.util.Date");
        mysql2JavaTypeMap.put("DATETIME", "java.util.Date");
        mysql2JavaTypeMap.put("BLOB", "byte[]");
        mysql2JavaTypeMap.put("BIT", "Boolean");
        mysql2JavaTypeMap.put("DECIMAL", "BigDecimal");
    }

    private void intTableDefList() {
        if (tableDefList == null) {
            this.tableDefList = new ArrayList<>();
            try {
                Connection connection = ds.getConnection();
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});

                while (tables.next()) {
                    String tableName = (String) tables.getObject("TABLE_NAME");
                    TableDef tableDef = new TableDef(tableName);

                    ResultSet columns = metaData.getColumns(null, null, tableName, null);
                    List<ColumnDef> columnDefs = new ArrayList<>();
                    List<ColumnDef> allColumnDefs = new ArrayList<>();
                    while (columns.next()) {
                        String columnType = columns.getString("TYPE_NAME");
                        String columnName = columns.getString("COLUMN_NAME");
                        ColumnDef columnDef = null;
                        if (commonColumns.contains(columnName.toUpperCase())) {
                            columnDef = new ColumnDef(columnName, columnType, true);
                        } else {
                            columnDef = new ColumnDef(columnName, columnType, false);
                            columnDefs.add(columnDef);
                        }
                        allColumnDefs.add(columnDef);
                    }
                    tableDef.setColumns(columnDefs);
                    tableDef.setAllColumns(allColumnDefs);
                    tableDefList.add(tableDef);
                    columns.close();
                }
                tables.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void generateDomainClass() throws Exception {

        System.out.println("generation domain class");

        intTableDefList();
        System.out.println("generation domain class" + tableDefList.toString());
        for (TableDef tableDef : this.tableDefList) {

            String className = getCamelStr(tableDef.getTableName(), true);
            Map<String, Object> dataMap = new HashMap<>();
            Set<String> imports = new HashSet<>();
            imports.addAll(commonImports);
            for (ColumnDef columnDef : tableDef.getColumns()) {
                if (columnDef.getFieldImport() != null) {
                    imports.add(columnDef.getFieldImport());
                }
            }

            dataMap.put("package", domainPkg);
            dataMap.put("imports", imports);
            dataMap.put("now", new Date());
            dataMap.put("tableName", tableDef.getTableName());
            dataMap.put("className", className);
            dataMap.put("fields", tableDef.getColumns());

            String javaFile = getPkgPath(domainPkg) + className + ".java";
            String templateName = "DomainClassTemplate.ftl";

            if (!fileExist(javaFile)) {
                freeMarkerUtilBean.generateJavaSource(templateName, javaFile, dataMap);
            }
        }
    }

    public void generateRepositoryClass() throws Exception {
        intTableDefList();
        for (TableDef tableDef : this.tableDefList) {
            String tableName = tableDef.getTableName();
            String domainClass = getCamelStr(tableName, true);

            Map<String, Object> dataMap = new HashMap<>();
            Set<String> imports = new HashSet<>();
            imports.add("import com.coalvalue.repository.base.BaseJpaRepository;");
            imports.add("import " + domainPkg + "." + domainClass + ";");

            dataMap.put("package", repositoryPkg);
            dataMap.put("imports", imports);
            dataMap.put("now", new Date());
            dataMap.put("domainClass", domainClass);
            dataMap.put("domainIdClass", "Integer");

            String javaFile = getPkgPath(repositoryPkg) + domainClass + "Repository.java";
            String templateName = "RepositoryClassTemplate.ftl";

            if (overrideFile || !fileExist(javaFile)) {
                freeMarkerUtilBean.generateJavaSource(templateName, javaFile, dataMap);
            }
        }
    }

    private String getPkgPath(String pkg) throws IOException {
        String javaSrc = ctx.getResource("").getURL().getPath().replace("webapp", "java");
        return javaSrc + pkg.replace(".", File.separator) + File.separator;
    }

    private String getCamelStr(String underLinedStr, boolean capFirst) {
        underLinedStr = underLinedStr.toLowerCase();
        String[] strs = underLinedStr.split("_");
        StringBuilder buffer = new StringBuilder();
        for (String str : strs) {
            String head = str.substring(0, 1).toUpperCase();
            String tail = str.substring(1);
            buffer.append(head).append(tail);
        }

        if (!capFirst) {
            StringBuilder result = new StringBuilder();
            String head = buffer.substring(0, 1).toLowerCase();
            String tail = buffer.substring(1);
            result.append(head).append(tail);
            return result.toString();
        }
        return buffer.toString();
    }

    private boolean fileExist(String file) {
        File f = new File(file);
        return f.exists();
    }


    public class TableDef {

        private String tableName;
        private List<ColumnDef> columns;
        private List<ColumnDef> allColumns;

        public TableDef(String tableName) {
            this.tableName = tableName;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public List<ColumnDef> getColumns() {
            return columns;
        }

        public void setColumns(List<ColumnDef> columns) {
            this.columns = columns;
        }

        public List<ColumnDef> getAllColumns() {
            return allColumns;
        }

        public void setAllColumns(List<ColumnDef> allColumns) {
            this.allColumns = allColumns;
        }

        @Override
        public String toString() {
            return "TableDef{" +
                    "tableName='" + tableName + '\'' +
                    ", allColumns=" + allColumns +
                    '}';
        }
    }

    public class ColumnDef {

        private String columnName;
        private String columnType;
        private boolean commonColumn;
        private String fieldName;
        private String fieldType;
        private String fieldImport;

        public ColumnDef(String columnName, String columnType, boolean commonColumn) {
            this.columnName = columnName;
            this.columnType = columnType;
            this.commonColumn = commonColumn;
            this.fieldName = getCamelStr(columnName, false);

            String fieldClass = mysql2JavaTypeMap.get(columnType.toUpperCase());
            if (fieldClass.contains(".")) {
                this.fieldImport = "import " + fieldClass + ";";
                this.fieldType = fieldClass.substring(fieldClass.lastIndexOf(".") + 1);
            } else {
                this.fieldImport = null;
                this.fieldType = fieldClass;
            }
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnType() {
            return columnType;
        }

        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldType() {
            return fieldType;
        }

        public void setFieldType(String fieldType) {
            this.fieldType = fieldType;
        }

        public String getFieldImport() {
            return fieldImport;
        }

        public void setFieldImport(String fieldImport) {
            this.fieldImport = fieldImport;
        }

        public boolean isCommonColumn() {
            return commonColumn;
        }

        public void setCommonColumn(boolean commonColumn) {
            this.commonColumn = commonColumn;
        }

        @Override
        public String toString() {
            return "ColumnDef{" +
                    "columnName='" + columnName + '\'' +
                    ", columnType='" + columnType + '\'' +
                    ", fieldName='" + fieldName + '\'' +
                    ", fieldType='" + fieldType + '\'' +
                    ", fieldImport='" + fieldImport + '\'' +
                    '}';
        }
    }
}
