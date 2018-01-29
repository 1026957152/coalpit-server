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

@Table(name = "behavioural")

public class Behavioural extends BaseDomain {




    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "license")
    private String license;


    private String type;
    @Column(name = "int_value")
    private Integer intValue;


    @Column(name = "string_value")
    private String stringValue;
   // private String params;



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
