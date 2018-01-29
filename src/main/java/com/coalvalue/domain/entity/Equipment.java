package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "equipment")

public class Equipment extends BaseDomain {



    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "pin")
    private String pin;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;
    private String type;
    private String deviceId;

    @Transient
    private String displayMode;

    @Transient
    private String displayConent;

    public Equipment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
    }

    public void setDisplayConent(String displayConent) {
        this.displayConent = displayConent;
    }

    public String getDisplayConent() {
        return displayConent;
    }


    ;
}
