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

@Table(name = "performance_object")

public class PerformanceObject extends BaseDomain {




    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "type")
    private String type;

    @Column(name = "note")
    private String note;
    @Column(name = "name")
    private String name;
    private String function;

    public PerformanceObject() {
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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    ;
}
