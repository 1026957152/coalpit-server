package com.coalvalue.enumType;

import com.coalvalue.configuration.CommonConstant;
import com.coalvalue.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/3/31.
 */
public enum CoalSupplyStatusEnum {

  //  结算方式(款到发货、货到付款、预付、付款期限


    INIT (CommonConstant.SUPPLY_STATUS_INIT,"初始化", 2,"初始化"),
    CREATED (CommonConstant.SUPPLY_STATUS_CREATE, "新建",2,"新建"),
    RELEASED (CommonConstant.SUPPLY_STATUS_RELEASED, "发布",2,"发布"),
    Cancel (CommonConstant.SUPPLY_STATUS_Cancel, "取消",2,"取消"),


    REJECTED (CommonConstant.PROMOTION_REJECTED,"拒绝", 2,"拒绝") ,

    CLOASE (CommonConstant.SUPPLY_STATUS_CLOSED,"关闭", 2,"关闭"),
    SUSPENDED (CommonConstant.SUPPLY_STATUS_SUSPENDED,"暂时关闭", 2,"暂时关闭"),
    inter_Marketing (CommonConstant.SUPPLY_STATUS_inter_Marketing,"内部销售", 2,"内部销售") ;;


    // 付款期限
    private final String statusText;
    private final String displayText;

    private final Integer id;
    private final String helpMessage;
    private String tipsMessage;


    public String getDisplayText() {
        return displayText;
    }

    private CoalSupplyStatusEnum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (CoalSupplyStatusEnum status : CoalSupplyStatusEnum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText(), status.getTipsMessage());
            list.add(element);
        }

        return list;

    }
    public static List<ListItem> retriveStatuses(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(CoalSupplyStatusEnum status : CoalSupplyStatusEnum.values()) {

            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }

        return list;

    }
    public static CoalSupplyStatusEnum fromString(String text) {
        for (CoalSupplyStatusEnum status : CoalSupplyStatusEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public String getTipsMessage() {
        return tipsMessage;
    }

    public void setTipsMessage(String tipsMessage) {
        this.tipsMessage = tipsMessage;
    }

    public static List<ListItem> retriveTypese(String scene) {
        List<ListItem> list = new ArrayList<ListItem>();


        if (ContextStateEnum.CONTEXT_SCENE_settlement_mode_hengshan_area.name().equals(scene)) {
            ListItem element = new ListItem(CREATED.getText(), CREATED.getDisplayText(), CREATED.getTipsMessage());
            list.add(element);
            element = new ListItem(RELEASED.getText(), RELEASED.getDisplayText(), RELEASED.getTipsMessage());

            list.add(element);


        }else {
            for (CoalSupplyStatusEnum status : CoalSupplyStatusEnum.values()) {
                ListItem element = new ListItem(status.getText(), status.getDisplayText(), status.getTipsMessage());
                list.add(element);
            }

        }
        return list;
    }


}
