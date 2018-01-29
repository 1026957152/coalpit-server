package com.coalvalue.configuration;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import javax.sql.DataSource;

/**
 * Created by zohu on 5/29/2015.
 */
@Configuration
//@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
public class DatabaseConfig {

 //   @Autowired
    private DataSource dataSource;
    @Autowired
    DBConfig dBConfig;
    public ProxoolDataSource proxoolDataSource(){
        ProxoolDataSource ds = new ProxoolDataSource();
        ds.setDriver(dBConfig.getDriverClassName());
        ds.setUser(dBConfig.getUsername());
        ds.setDriverUrl(dBConfig.getUrl());
        ds.setPassword(dBConfig.getPassword());
        ds.setMaximumConnectionCount(10);
        ds.setMinimumConnectionCount(2);
        ds.setSimultaneousBuildThrottle(5);
        return ds;
    }
    //自定义的DataSource，默认方法名就是bean的id
    @Bean
    @Primary
    public DataSource dataSource(){
        try {
            this.dataSource = new LazyConnectionDataSourceProxy(proxoolDataSource());
            return dataSource;
        }catch (NullPointerException e) {
            System.out.printf("we get null dataSource");
            e.printStackTrace();
            return null;
        }
    }


    @Bean(name = "orderNoGenerator")
    public MySQLMaxValueIncrementer getOrderNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_orderNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
    //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");

        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "contractNoGenerator")
    public MySQLMaxValueIncrementer getContractNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_contractNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
      //  mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "dealNoGenerator")
    public MySQLMaxValueIncrementer getDealNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_dealNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
      //  mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }


    @Bean(name = "companyNoGenerator")
    public MySQLMaxValueIncrementer getCompanyNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_companyNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
    //    mySQLMaxValueIncrementer.setCacheSize(10000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(5);
        return mySQLMaxValueIncrementer;
    }


    @Bean(name = "supplyNoGenerator")
    public MySQLMaxValueIncrementer getSupplyNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_supplyNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
   //     mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "demandNoGenerator")
    public MySQLMaxValueIncrementer getDemandNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_demandNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
  //      mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }


    @Bean(name = "shippingNoGenerator")
    public MySQLMaxValueIncrementer getShippingNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_shippingNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
     //   mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "userNoGenerator")
    public MySQLMaxValueIncrementer getUserNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_userNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
    //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "capacityNoGenerator")
    public MySQLMaxValueIncrementer getCapacityNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_capacityNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "uuidNoGenerator")
    public MySQLMaxValueIncrementer getUuidNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_uuidNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(32);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "scanIdGenerator")
    public MySQLMaxValueIncrementer getScanIdGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_scanId");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(32);
        return mySQLMaxValueIncrementer;
    }


    @Bean(name = "transportNoGenerator")
    public MySQLMaxValueIncrementer getTransportNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_transportyNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }

    @Bean(name = "teamDealNoGenerator")
    public MySQLMaxValueIncrementer getTeamDealNoGenerator() {
        MySQLMaxValueIncrementer mySQLMaxValueIncrementer = new MySQLMaxValueIncrementer();
        mySQLMaxValueIncrementer.setColumnName("gen_teamDealNo");
        mySQLMaxValueIncrementer.setDataSource(dataSource);
        //    mySQLMaxValueIncrementer.setCacheSize(100000);
        mySQLMaxValueIncrementer.setIncrementerName("tb_generator");
        mySQLMaxValueIncrementer.setPaddingLength(8);
        return mySQLMaxValueIncrementer;
    }















}
