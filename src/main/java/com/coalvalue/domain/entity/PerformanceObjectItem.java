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

@Table(name = "performance_object_item")

public class PerformanceObjectItem extends BaseDomain {

    @Column(name = "object_id")
    private Integer objectId;


    @Column(name = "item_id")
    private Integer itemId;



    @Column(name = "type")
    private String type;

    @Column(name = "note")
    private String note;
    @Column(name = "name")
    private String name;
    private BigDecimal weight;

    public PerformanceObjectItem() {
    }



    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    ;
}
