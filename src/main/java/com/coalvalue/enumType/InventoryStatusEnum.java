package com.coalvalue.enumType;

import com.coalvalue.configuration.CommonConstant;
import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/3/31.
 */
public enum InventoryStatusEnum {


    OPEN (CommonConstant.STATUS_STORAGE_OPEN,"开放",1,"一票就是将货物的金额和运费的金额合在一起统一出一张增值税专用发票。"),

    CLOSE (CommonConstant.STATUS_STORAGE_CLOSE,"关闭", 5,"两票是分开出，货物的发票由销货方出发票，运费由运输方出具发票。");


    private final String statusText;
    private final String displayText;

    private final Integer id;
    private final String helpMessage;
    private String tipsMessage;


    public String getDisplayText() {
        return displayText;
    }

    private InventoryStatusEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (InventoryStatusEnum status : InventoryStatusEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText(), status.getTipsMessage());
            list.add(element);
        }

        return list;

    }

    public String getTipsMessage() {
        return tipsMessage;
    }

    public void setTipsMessage(String tipsMessage) {
        this.tipsMessage = tipsMessage;
    }



    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(InventoryStatusEnum status : InventoryStatusEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static InventoryStatusEnum fromString(String text) {
        for (InventoryStatusEnum status : InventoryStatusEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<InventoryStatusEnum> created) {

        List<String> status = new ArrayList<>();
        for(InventoryStatusEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
