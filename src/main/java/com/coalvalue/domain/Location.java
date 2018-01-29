package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "location")
public class Location extends BaseDomain {

    @Column(name = "name")
    private String name;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Location() {
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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
