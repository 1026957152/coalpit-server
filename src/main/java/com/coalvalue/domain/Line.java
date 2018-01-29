package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "line")
public class Line extends BaseDomain {

    @Column(name = "line_name")
    private String lineName;

    @Column(name = "departure_station")
    private Integer departureStation;

    @Column(name = "arrival_station")
    private Integer arrivalStation;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Line() {
    }

    public String getLineName() {
        return lineName;
    }

    public Integer getDepartureStation() {
        return departureStation;
    }

    public Integer getArrivalStation() {
        return arrivalStation;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public void setDepartureStation(Integer departureStation) {
        this.departureStation = departureStation;
    }

    public void setArrivalStation(Integer arrivalStation) {
        this.arrivalStation = arrivalStation;
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
