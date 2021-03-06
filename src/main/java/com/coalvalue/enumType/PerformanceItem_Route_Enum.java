package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum PerformanceItem_Route_Enum {


    Total_count ("Total_In_count", "总出数量",2,""),

    TAX_Inclusive_PRICE ("TAX_Inclusive_PRICE","含税价格", 2,""),
    TAX_Exclusive_PRICE ("TAX_Exclusive_PRICE","不含税价格", 2,""),
    Total_dealInstance_count ("Total_dealInstance_count","全部交易数", 2,""),

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

    private PerformanceItem_Route_Enum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (PerformanceItem_Route_Enum status : PerformanceItem_Route_Enum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(PerformanceItem_Route_Enum status : PerformanceItem_Route_Enum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static PerformanceItem_Route_Enum fromString(String text) {
        for (PerformanceItem_Route_Enum status : PerformanceItem_Route_Enum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<PerformanceItem_Route_Enum> created) {

        List<String> status = new ArrayList<>();
        for(PerformanceItem_Route_Enum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
