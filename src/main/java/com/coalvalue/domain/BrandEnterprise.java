package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yuan zhao  on 10/18/2015.
 */
@Entity
@Table(name = "brand_enterprise")
public class BrandEnterprise extends BaseDomain {



    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_type")
    private String itemType;

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

    @Column(name = "enterprise_index")
    private Integer index;

    @Column(name = "note")
    private String note;


    @Column(name = "status")
    private String status;

    @Column(name = "feature")
    private String feature;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public BrandEnterprise() {
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }


    public Integer getIndex() {
        return index;
    }

    public String getNote() {
        return note;
    }


    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
