package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "station")
public class Station extends BaseDomain {

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    public Station() {
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
