package com.coalvalue.domain;

import com.coalvalue.domain.entity.LogMessage;
import com.coalvalue.enumType.WX_REQUEST_RESPONSE_Enum;

import java.io.Serializable;

/**
 * Created by silence on 2016-09-24.
 */
public class SmsParameter implements Serializable {

    private static final long serialVersionUID = -658250125732806493L;
    private String toUserName;
    private String fromUserName;

    private WX_REQUEST_RESPONSE_Enum requestType;
    private Boolean authenticated;
    private Integer userId;
    private String phoneNumber;
    private String text;
    private LogMessage logMessage;

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }



    public void setRequestType(WX_REQUEST_RESPONSE_Enum requestType) {
        this.requestType = requestType;
    }

    public WX_REQUEST_RESPONSE_Enum getRequestType() {
        return requestType;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Boolean isAuthenticated() {
        return authenticated;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setLogMessage(LogMessage logMessage) {
        this.logMessage = logMessage;
    }

    public LogMessage getLogMessage() {
        return logMessage;
    }
}
