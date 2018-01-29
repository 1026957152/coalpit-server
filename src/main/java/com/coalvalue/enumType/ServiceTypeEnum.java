package com.coalvalue.enumType;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2016/1/18.
 */
public enum ServiceTypeEnum {


    Hubot ("Hubot", "LanhuaHubot服务",2,""),
    LED ("LED", "LED服务",2,""),

    INDEX_STATISTIC ("INDEX_STATISTIC","榆林煤价格指数统计服务", 2,"");






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

    private ServiceTypeEnum(String statusText, String displayText, Integer id, String helpMessage) {
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



    public static ServiceTypeEnum fromString(String text) {
        for (ServiceTypeEnum status : ServiceTypeEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }

    public static List<String> toStringList(List<ServiceTypeEnum> created) {

        List<String> status = new ArrayList<>();
        for(ServiceTypeEnum canvassingStatusEnum : created){
            status.add(canvassingStatusEnum.getText());
        }
        return status;
    }
}
