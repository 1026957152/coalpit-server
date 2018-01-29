package com.coalvalue.domain;

import com.coalvalue.domain.entity.LogMessage;
import com.coalvalue.weixin.pojo.resp.Article;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CrunchifyMessage implements Serializable {

    private static final long serialVersionUID = -658250125732806493L;

    private String crunchifyMsg;
    private Integer logMessageId;
    private LogMessage logMessage;
    private Integer user;
    private String openId;
    private String messageType;
    private List<Article> crunchifyArticles;
    private List<String> openIds;
    List<Map<String,Object>> openIdMessage;
    private List<String> templateMessages;
    private String templateMessage;

    public List<Map<String, Object>> getOpenIdMessage() {
        return openIdMessage;
    }

    public void setOpenIdMessage(List<Map<String, Object>> openIdMessage) {
        this.openIdMessage = openIdMessage;
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

    public CrunchifyMessage() {
    }

    public Integer getLogMessageId() {
        return logMessageId;
    }

    public void setLogMessageId(Integer logMessageId) {
        this.logMessageId = logMessageId;
    }

    public CrunchifyMessage(String string) {
        this.crunchifyMsg = string;
    }

    public String getCrunchifyMsg() {
        return crunchifyMsg;
    }

    public void setCrunchifyMsg(String crunchifyMsg) {
        this.crunchifyMsg = crunchifyMsg;
    }

    public String getMsg() {
        return crunchifyMsg;
    }

    public void setLogMessage(LogMessage logMessage) {
        this.logMessage = logMessage;
    }

    public LogMessage getLogMessage() {
        return logMessage;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getUser() {
        return user;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setCrunchifyArticles(List<Article> crunchifyArticles) {
        this.crunchifyArticles = crunchifyArticles;
    }

    public List<Article> getCrunchifyArticles() {
        return crunchifyArticles;
    }

    public void setTemplateMessages(List<String> templateMessages) {
        this.templateMessages = templateMessages;
    }

    public List<String> getTemplateMessages() {
        return templateMessages;
    }

    public void setTemplateMessage(String templateMessage) {
        this.templateMessage = templateMessage;
    }

    public String getTemplateMessage() {
        return templateMessage;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}