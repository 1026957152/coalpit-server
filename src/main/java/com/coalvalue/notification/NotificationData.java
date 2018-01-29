package com.coalvalue.notification;

import com.coalvalue.domain.entity.PlateRecognition;
import org.springframework.security.core.Authentication;

public class NotificationData {
     
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String fromUserName;
    private String toUserName;
    private String openId;
    private String eventKey;
    private String eventType;
    private String msgType;
    private String content;
    private Authentication authentication;
    private PlateRecognition object;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setObject(PlateRecognition object) {
        this.object = object;
    }

    public PlateRecognition getObject() {
        return object;
    }
    // getter and setter methods
}