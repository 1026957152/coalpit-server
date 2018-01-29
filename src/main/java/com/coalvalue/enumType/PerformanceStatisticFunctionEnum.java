package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum PerformanceStatisticFunctionEnum {


    CONSTRUCT_YULINMEI_INDEX ("CONSTRUCT_YULINMEI_INDEX", "构建榆林煤指数",2,""),
    INSTANCE_PRICE_CHANGE_RANK ("INSTANCE_PRICE_CHANGE_RANK", "及时价格变化",2,""),
    INSTANCE_INVENTORY_RANK ("INSTANCE_INVENTORY_RANK", "库存变化",2,""),
    INSTANCE_PRODUCT_STATUS_VARIATION ("INSTANCE_PRODUCT_STATUS_VARIATION", "及时变化",2,""),

    INSTANCE_PRICE_BY_GRANULARITY_BY_AREA ("INSTANCE_PRICE_BY_GRANULARITY_BY_AREA","INSTANCE_PRICE_BY_GRANULARITY_BY_AREA", 2,""),
    RECORD_COMPANY_STATUS ("RECORD_COMPANY_STATUS","RECORD_COMPANY_STATUS", 2,""),
    CONSTRUCT_ROUTE_AVERAGE_FREIGHT ("CONSTRUCT_ROUTE_AVERAGE_FREIGHT", "路线均价",2,""),
    TOTAL_ROUTE ("TOTAL_ROUTE", "路线均价",2,""),
    INSTANCE_USER_REGISTER ("INSTANCE_USER_REGISTER", "INSTANCE_USER_REGISTER",2,""),

    ;







    private final String statusText;
    private final String displayText;
    private final Integer id;

    private String helpMessage;

    public String getHelpMessage() {
        return helpMessage;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public String getDisplayText() {
        return displayText;
    }

    private PerformanceStatisticFunctionEnum(String statusText, String displayText, Integer id, String helpMessage) {
        this.statusText = statusText;
        this.displayText = displayText;

        this.id = id;
        this.helpMessage = helpMessage;
    }
    public String getText() {
        return this.statusText;
    }

    public Integer getId() {
        return this.id;
    }


    public static List<ListItem> retriveTypese() {

        List<ListItem> list = new ArrayList<ListItem>();
        for (PerformanceStatisticFunctionEnum status : PerformanceStatisticFunctionEnum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(PerformanceStatisticFunctionEnum status : PerformanceStatisticFunctionEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static PerformanceStatisticFunctionEnum fromString(String text) {
        for (PerformanceStatisticFunctionEnum status : PerformanceStatisticFunctionEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<PerformanceStatisticFunctionEnum> created) {

        List<String> status = new ArrayList<>();
        for(PerformanceStatisticFunctionEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
