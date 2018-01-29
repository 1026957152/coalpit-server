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

@Table(name = "inventory_transfer")

public class InventoryTransfer extends BaseDomain {




    @Column(name = "amount")
    private BigDecimal amount;


    @Column(name = "type")
    private String type;

    public InventoryTransfer() {
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

;
}
