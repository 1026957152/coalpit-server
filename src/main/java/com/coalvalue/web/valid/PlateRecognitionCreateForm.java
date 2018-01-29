package com.coalvalue.web.valid;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by silence on 2016/1/23.
 */
public class PlateRecognitionCreateForm {


    private Integer colourCode;

    private String serialNo;

    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    private Date timeStamp;



    private String direction;

    @NotNull
    private String license;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }



}
