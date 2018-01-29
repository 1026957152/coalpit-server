package com.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@javax.persistence.Entity

@Table(name = "events")

public class Events extends BaseDomain {






    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_subtype")
    private String eventSubtype;



    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "item_id")
    private Integer itemId;

    public String getUserName() {
        return userName;
    }


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "note")
    private String note;


    public Events() {
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventSubtype() {
        return eventSubtype;
    }

    public void setEventSubtype(String eventSubtype) {
        this.eventSubtype = eventSubtype;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
