package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "plate_recognition")

public class PlateRecognition extends BaseDomain {

    @Column(name = "colour_code")
    private Integer colourCode;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "license")
    private String license;
    private String type;

    private String direction;


    @Column(name = "timeStamp")
    private Date timeStamp;

    public Integer getColourCode() {
        return colourCode;
    }

    public void setColourCode(Integer colourCode) {
        this.colourCode = colourCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}
