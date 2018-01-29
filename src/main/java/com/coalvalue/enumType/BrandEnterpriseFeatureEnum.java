package com.coalvalue.enumType;

import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum BrandEnterpriseFeatureEnum {


    BRAND_STATION ("BRAND_STATION","榆林煤炭知名站台", 2,""),

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

    private BrandEnterpriseFeatureEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (BrandEnterpriseFeatureEnum status : BrandEnterpriseFeatureEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }

        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(BrandEnterpriseFeatureEnum status : BrandEnterpriseFeatureEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static BrandEnterpriseFeatureEnum fromString(String text) {
        for (BrandEnterpriseFeatureEnum status : BrandEnterpriseFeatureEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<BrandEnterpriseFeatureEnum> created) {

        List<String> status = new ArrayList<>();
        for(BrandEnterpriseFeatureEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
