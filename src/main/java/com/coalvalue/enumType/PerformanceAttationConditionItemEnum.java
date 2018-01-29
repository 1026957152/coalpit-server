package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum PerformanceAttationConditionItemEnum {


    DISTRICT_COMPANY ("DISTRICT_COMPANY", "DISTRICT_COMPANY",2,""),
    DISTRICT_GRANULARITY ("DISTRICT_GRANULARITY", "DISTRICT_COMPANY",2,""),

    paied ("已支付","已支付", 2,""),
 ;// 请求结算






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

    private PerformanceAttationConditionItemEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (PerformanceAttationConditionItemEnum status : PerformanceAttationConditionItemEnum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(PerformanceAttationConditionItemEnum status : PerformanceAttationConditionItemEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static PerformanceAttationConditionItemEnum fromString(String text) {
        for (PerformanceAttationConditionItemEnum status : PerformanceAttationConditionItemEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<PerformanceAttationConditionItemEnum> created) {

        List<String> status = new ArrayList<>();
        for(PerformanceAttationConditionItemEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
