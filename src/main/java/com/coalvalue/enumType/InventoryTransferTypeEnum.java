package com.coalvalue.enumType;

/**
 * Created by silence on 2016/1/18.
 */
public enum InventoryTransferTypeEnum {


    IN ("in", "增加",2,""),
    OUT ("out", "减少",2,"") ;// 请求结算






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

    private InventoryTransferTypeEnum(String statusText, String displayText, Integer id, String helpMessage) {
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





    public static InventoryTransferTypeEnum fromString(String text) {
        for (InventoryTransferTypeEnum status : InventoryTransferTypeEnum.values()) {
            if (status.getText().equals(text) ) {
                return status;
            }
        }
        throw new RuntimeException("no customer status " + text);
    }


}
