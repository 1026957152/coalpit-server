package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "time_statistic")

public class TimeStatistic extends BaseDomain {





    @Column(name = "count")
    private Integer count;

    private Integer priceUpCount;
    private Integer priceDownCount;

    public Integer getPriceUpCount() {
        return priceUpCount;
    }

    public void setPriceUpCount(Integer priceUpCount) {
        this.priceUpCount = priceUpCount;
    }

    public Integer getPriceDownCount() {
        return priceDownCount;
    }

    public void setPriceDownCount(Integer priceDownCount) {
        this.priceDownCount = priceDownCount;
    }

    @Column(name = "interval_")
    private String interval;

    public TimeStatistic() {
    }

    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
