package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import com.coalvalue.enumType.PriceCategoryStatusEnum;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "price_category")

public class PriceCategory extends BaseDomain {

    private String name;

    private BigDecimal value;

    private String itemType;

    private Integer itemId;
    private String trend;
    private Boolean major;
    private String status;
    private Integer seq;
    private BigDecimal expectedValue;

    public Boolean getMajor() {
        return major;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setMajor(Boolean major) {
        this.major = major;
    }

    private Date lastChangeTime;

    public PriceCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public String getTrend() {
        return trend;
    }

    public void setLastChangeTime(Date lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public Date getLastChangeTime() {
        return lastChangeTime;
    }

    public String getStatus() {
        return status == null? PriceCategoryStatusEnum.CLOSE.getText() : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(BigDecimal expectedValue) {
        this.expectedValue = expectedValue;
    }
}
