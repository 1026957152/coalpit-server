package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "platform")
public class Platform extends BaseDomain {

    @Column(name = "stationID")
    private Integer stationid;

    @Column(name = "platformNumber")
    private String platformnumber;

    @Column(name = "status")
    private String status;

    @Column(name = "note")
    private String note;

    @Column(name = "type")
    private String type;

    public Platform() {
    }

    public Integer getStationid() {
        return stationid;
    }

    public String getPlatformnumber() {
        return platformnumber;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public String getType() {
        return type;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public void setPlatformnumber(String platformnumber) {
        this.platformnumber = platformnumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
