package com.coalvalue.enumType;

import com.domain.pojo.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum WX_REQUEST_RESPONSE_Enum {




    我的关注 ("myFavorite", "我的关注",2,""),
    煤矿直销 ("currentPromotion", "煤矿直销",2,""),

    经销商供给 ("currentSupply", "经销商供给",2,""),


    帮助 ("help","帮助", 2,""),
    运力需求信息 ("currentCapacity","运力需求信息", 2,""),
    个人空车信息 ("currentCapacitySupply","个人空车信息", 2,""),
    团购 ("teamPurchasing","团购", 2,""),



    扫二维码_堆场队列 ("扫二维码_堆场队列","扫二维码_堆场队列", 2,"") ,
     扫二维码_公司("扫二维码_公司","扫二维码_公司", 2,"") ,
    扫二维码_区域_主题("扫二维码_区域_主题","扫二维码_区域_主题", 2,"") ;


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

    private WX_REQUEST_RESPONSE_Enum(String statusText, String displayText, Integer id, String helpMessage) {
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
        for (WX_REQUEST_RESPONSE_Enum status : WX_REQUEST_RESPONSE_Enum.values()) {
            ListItem element = new ListItem(status.getId(), status.getDisplayText(), status.getHelpMessage());
            list.add(element);
        }
        return list;

    }


    public static List<ListItem> retriveTypese(String statusText) {

        List<ListItem> list = new ArrayList<ListItem>();
        for(WX_REQUEST_RESPONSE_Enum status : WX_REQUEST_RESPONSE_Enum.values()) {
            ListItem element = new ListItem(status.getText(), status.getDisplayText());
            if (status.getText().equals(statusText)){
                element.setSelected(true);
            }
            list.add(element);
        }
        return list;

    }
    public static WX_REQUEST_RESPONSE_Enum fromString(String text) {
        for (WX_REQUEST_RESPONSE_Enum status : WX_REQUEST_RESPONSE_Enum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<WX_REQUEST_RESPONSE_Enum> created) {
        List<String> status = new ArrayList<String>();
        for(WX_REQUEST_RESPONSE_Enum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
