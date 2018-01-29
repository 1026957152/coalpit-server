package com.domain;

import java.io.Serializable;

/**
 * Created by silence on 2016-09-24.
 */
public class QueueRequest implements Serializable {

    private static final long serialVersionUID = -658250125732806493L;
    private String toUserName;
    private String fromUserName;


    private Boolean authenticated;
    private Integer userId;

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
}
