package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2017-05-27.
 */
public enum StatisticPerformanceTypeEnum {



    SYSTEM_capacity_issued_count("SYSTEM_capacity_issued_count", "发布的运输需求",2,""),
    digest("digest", "digest",2,""),
    ID("ID", "ID",2,""),

    COMPANY_transport_issued_count("COMPANY_transport_issued_count", "开据的提煤单数量",2,""),
    COMPANY_transport_used_count("COMPANY_transport_used_count", "已使用的提煤单数量",2,""),


    COMPANY_canvassing_issued_count ("COMPANY_canvassing_issued_count", "收到的应单信息",2,""),

    COLLABORATOR_transport_issued_count ("COLLABORATOR_transport_issued_count","开据的提煤单数量", 2,""),
    COLLABORATOR_transport_used_count ("COLLABORATOR_transport_issued_count","已使用的提煤单数量", 2,""),

    COLLABORATOR_transport_total_quantity ("COLLABORATOR_transport_total_quantity","提煤数量", 2,""),


    COMPANY_sales_total_quantity ("COMPANY_sales_total_quantity", "销售总量",2,""),

    DISTRICT_avarage_price ("DISTRICT_avarage_price", "区域平均价格",2,""),
    PRODUCT_price_descend_count ("PRODUCT_price_descend_count", "下降量",2,""),
    PRODUCT_price_ascend_count ("PRODUCT_price_ascend_count", "上升量",2,""),


    STORAGE_instance_transport_waiting_count ("STORAGE_instance_transport_waiting_count", "堆场等地车辆",2,""),
    YARD_QUEUING_instance_transport_waiting_count ("YARD_QUEUING_instance_transport_waiting_count", "堆场等地车辆",2,""),
    YARD_QUEUING_instance_transport_loading_count("YARD_QUEUING_instance_transport_loading_count", "堆场等地车辆",2,""),

    STORAGE_instance_transport_loading_count("STORAGE_instance_transport_loading_count", "堆场等地车辆",2,""),

    transport_used_count ("transport_issued_count","已使用的提煤单数量", 2,""),

    sales_total_quantity ("sales_total_quantity", "销售总量",2,""),
    capacity_issued_count("capacity_issued_count", "发布的运输需求",2,"");


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

    private StatisticPerformanceTypeEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (StatisticPerformanceTypeEnum status : StatisticPerformanceTypeEnum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(StatisticPerformanceTypeEnum status : StatisticPerformanceTypeEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static StatisticPerformanceTypeEnum fromString(String text) {
        for (StatisticPerformanceTypeEnum status : StatisticPerformanceTypeEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<StatisticPerformanceTypeEnum> created) {

        List<String> status = new ArrayList<>();
        for(StatisticPerformanceTypeEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
