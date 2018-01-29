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

@Table(name = "product")

public class Product extends BaseDomain {


    @Column(name = "note")
    private String note;

    @Column(name = "item_Id")
    private Integer itemId;


    @Column(name = "itemType")
    private String itemType;
    private Integer companyId;
    private Integer storageId;



    @Column(name = "quality_report_id")
    private Integer qualityReportId;

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


    @Column(name = "no")
    private String no;

    @Column(name = "status")
    private String status;

    @Column(name = "coal_Type")
    private String coalType;

    @Column(name = "granularity")
    private String granularity;


    public Product() {
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoalType() {
        return coalType;
    }

    public void setCoalType(String coalType) {
        this.coalType = coalType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public void setQualityReportId(Integer qualityReportId) {
        this.qualityReportId = qualityReportId;
    }

    public Integer getQualityReportId() {
        return qualityReportId;
    }

    ;
}
