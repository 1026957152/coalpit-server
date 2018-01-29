package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by silence yuan on 2015/7/25.
 */

@Entity
@Table(name = "quality_test_item")
public class QualityTestItem extends BaseDomain {

    @Column(name = "inspection_application_id")
    private Integer inspectionApplicationId;

    @Column(name = "inspection_report_id")
    private Integer inspectionReportId;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "unit")
    private String unit;

    @Column(name = "item_value")
    private String value;

    @Column(name = "insolation_method")
    private String insolationMethod;


    @Column(name = "sampling_time")
    private Date sampling_time;

    @Column(name = "item_index")
    private Integer index;

    @Column(name = "status")
    private String status;

    @Column(name = "note")
    private String note;



    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        if(value == null){

            return "-1";
        }
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public Date getSampling_time() {
        return sampling_time;
    }

    public void setSampling_time(Date sampling_time) {
        this.sampling_time = sampling_time;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getInspectionApplicationId() {
        return inspectionApplicationId;
    }

    public void setInspectionApplicationId(Integer inspectionApplicationId) {
        this.inspectionApplicationId = inspectionApplicationId;
    }

    public Integer getInspectionReportId() {
        return inspectionReportId;
    }

    public void setInspectionReportId(Integer inspectionReportId) {
        this.inspectionReportId = inspectionReportId;
    }

    public String getInsolationMethod() {
        return insolationMethod;
    }

    public void setInsolationMethod(String insolationMethod) {
        this.insolationMethod = insolationMethod;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
