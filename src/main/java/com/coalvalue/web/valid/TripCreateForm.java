package com.coalvalue.web.valid;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by silence on 2016/1/23.
 */
public class TripCreateForm {


    private Integer lineId;

    private Date departureTime;

    private Date arrivalTime;

    private String description;

    private String status;



    private Integer id;
    private BigDecimal openTopWagonPrice;
    private BigDecimal flatWagonPrice;

    public void setFlatWagonPrice(BigDecimal flatWagonPrice) {
        this.flatWagonPrice = flatWagonPrice;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getOpenTopWagonPrice() {
        return openTopWagonPrice;
    }

    public void setOpenTopWagonPrice(BigDecimal openTopWagonPrice) {
        this.openTopWagonPrice = openTopWagonPrice;
    }

    public BigDecimal getFlatWagonPrice() {
        return flatWagonPrice;
    }
}
