package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "trip")
public class Trip extends BaseDomain {

    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;



    @Column(name = "flat_wagon_price")
    private BigDecimal flatWagonPrice;

    @Column(name = "open_top_wagon")
    private BigDecimal openTopWagonPrice ;

    public BigDecimal getFlatWagonPrice() {
        return flatWagonPrice;
    }

    public void setFlatWagonPrice(BigDecimal flatWagonPrice) {
        this.flatWagonPrice = flatWagonPrice;
    }

    public BigDecimal getOpenTopWagonPrice() {
        return openTopWagonPrice;
    }

    public void setOpenTopWagonPrice(BigDecimal openTopWagonPrice) {
        this.openTopWagonPrice = openTopWagonPrice;
    }

    public Trip() {
    }

    public Integer getLineId() {
        return lineId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
