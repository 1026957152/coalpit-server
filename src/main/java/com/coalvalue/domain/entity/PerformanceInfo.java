package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "performance_info")

public class PerformanceInfo extends BaseDomain {




    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "note")
    private String note;

    @Column(name = "name")
    private String name;

    @Column(name = "value_type")
    private String valueType;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "decimal_value")
    private BigDecimal decimalValue;

    public PerformanceInfo() {
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
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

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public BigDecimal getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(BigDecimal decimalValue) {
        this.decimalValue = decimalValue;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
