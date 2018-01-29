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

@Table(name = "time_statistic_performance")

public class TimeStatisticPerformance extends BaseDomain {

    @Column(name = "time_id")
    private Integer timeId;

    @Column(name = "performance_id")
    private Integer performanceId;


    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "decimal_value")
    private BigDecimal decimalValue;


    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public TimeStatisticPerformance() {
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
