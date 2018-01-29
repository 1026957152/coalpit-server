package com.domain.pojo;

/**
 * Created by silence on 2017/1/19.
 */

public class PushNotificationMessage {


    private String text;
    private String type;
    private String id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
