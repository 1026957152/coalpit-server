package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yuan zhao  on 07/25/2015.
 */
@Entity
@Table(name = "quality_inspection_report")
public class QualityInspectionReport extends BaseDomain {



    @Column(name = "inspection")
    private Integer inspection;

    @Column(name = "inspection_organization")
    private String inspectionOrganization;

    @Column(name = "consignment_company")
    private String consignmentCompany;

    @Column(name = "inspection_location")
    private String inspectionLocation;

    @Column(name = "customer_service_id")
    private Integer customerServiceId;

    @Column(name = "sampling_personnel")
    private String samplingPersonnel;

    @Column(name = "inspection_status")
    private String inspectionStatus;

    @Column(name = "sampling_time")
    private Date samplingTime;

    @Column(name = "remark")
    private String remark;
    private Integer companyId;

    public QualityInspectionReport() {
    }

    public Integer getInspection() {
        return inspection;
    }

    public String getInspectionOrganization() {
        return inspectionOrganization;
    }

    public String getConsignmentCompany() {
        return consignmentCompany;
    }

    public String getInspectionLocation() {
        return inspectionLocation;
    }

    public Integer getCustomerServiceId() {
        return customerServiceId;
    }

    public String getSamplingPersonnel() {
        return samplingPersonnel;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public Date getSamplingTime() {
        return samplingTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setInspection(Integer inspection) {
        this.inspection = inspection;
    }

    public void setInspectionOrganization(String inspectionOrganization) {
        this.inspectionOrganization = inspectionOrganization;
    }

    public void setConsignmentCompany(String consignmentCompany) {
        this.consignmentCompany = consignmentCompany;
    }

    public void setInspectionLocation(String inspectionLocation) {
        this.inspectionLocation = inspectionLocation;
    }

    public void setCustomerServiceId(Integer customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    public void setSamplingPersonnel(String samplingPersonnel) {
        this.samplingPersonnel = samplingPersonnel;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public void setSamplingTime(Date samplingTime) {
        this.samplingTime = samplingTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }
}
