package com.coalvalue.domain.entity;


import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "log_message")

public class LogMessage extends BaseDomain {

    private static final long serialVersionUID = -658250125732806493L;





    @Column(name = "open_id")
    private String openId;

    @Column(name = "user_id")
    private Integer userId;


    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "message_type")
    private String messageType;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private String content;
    private Integer eventId;
    private String msgid;

    public LogMessage() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }



    ;
}
