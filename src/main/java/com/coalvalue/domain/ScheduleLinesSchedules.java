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
@Table(name = "schedule_lines_schedules")
public class ScheduleLinesSchedules extends BaseDomain {

    @Column(name = "trip_id")
    private Integer tripId;

    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public ScheduleLinesSchedules() {
    }

    public Integer getTripId() {
        return tripId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
