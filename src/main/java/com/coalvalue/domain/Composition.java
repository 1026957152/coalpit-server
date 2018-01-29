package com.coalvalue.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Peter Xu on 10/02/2017.
 */
@Entity
@Table(name = "composition")
public class Composition extends BaseDomain {

    @Column(name = "code")
    private String code;

    @Column(name = "cars")
    private Integer cars;

    @Column(name = "operator_id")
    private Integer operatorId;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "additional_capacity")
    private Integer additionalCapacity;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public Composition() {
    }

    public String getCode() {
        return code;
    }

    public Integer getCars() {
        return cars;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getAdditionalCapacity() {
        return additionalCapacity;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setAdditionalCapacity(Integer additionalCapacity) {
        this.additionalCapacity = additionalCapacity;
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
