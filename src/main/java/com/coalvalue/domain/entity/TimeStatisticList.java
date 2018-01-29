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

@Table(name = "time_statistic_list")

public class TimeStatisticList extends BaseDomain {

    @Column(name = "time_id")
    private Integer timeId;


    @Column(name = "item_id")
    private Integer itemId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "decimal_value")
    private BigDecimal decimalValue;

    @Column(name = "type")
    private String type;

    public TimeStatisticList() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
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
}
