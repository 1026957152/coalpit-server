package com.coalvalue.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Peter Xu on 03/28/2015.
 */
public class LineDto {

    private Integer id;

    private Integer ownerId;

    private Integer companyId;



    private String granularity;

    private String category;

    private String supplyArea;

    private String deliveryManner;

    //一些煤炭質量指标，
    private String totalMoisture;

    private String mtExp;

    private String ashContent;

    private String ashBasic;

    private String ashExp;

    private String volatileMatter;

    private String vmBasic;

    private String vmExp;

    private String sulfurMatter;

    private String sulfurBasic;

    private String sulfurExp;

    private String netCalorificValue;


    private String ncBasic;

    private String ncExp;


    private String size;


    private String sizeExp;


    private String fixedCarbon;


    private String fcBasic;

    private String fcExp;


    //一些其他限制条件
    private String sortBy;

    private String myRelease;

    private String certified;
    private Date expireDate;

    private Boolean verified;
    private List<String> statuses;
    private String status;


    private Integer qnetarMax;
    private Integer qnetarMin;
    private Integer aarMin;
    private Integer aarMax;
    private Integer starMin;
    private Integer starMax;
    private Integer modMin;
    private Integer modMax;
    private Integer varMin;
    private Integer varMax;
    private Integer crcMin;
    private Integer crcMax;
    private Integer mtMin;
    private Integer mtMax;

    private Integer gMin;
    private Integer gMax;
    private Integer qgradMax;
    private Integer qgradMin;
    private String deliveryMode;
    private Integer district;
    private String street;
    private String city;
    private String province;
    private Integer departureStation;

    public Integer getgMax() {
        return gMax;
    }

    public void setgMax(Integer gMax) {
        this.gMax = gMax;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Integer getAarMin() {
        return aarMin;
    }

    public void setAarMin(Integer aarMin) {
        this.aarMin = aarMin;
    }

    public Integer getAarMax() {
        return aarMax;
    }

    public void setAarMax(Integer aarMax) {
        this.aarMax = aarMax;
    }

    public Integer getStarMin() {
        return starMin;
    }

    public void setStarMin(Integer starMin) {
        this.starMin = starMin;
    }

    public Integer getStarMax() {
        return starMax;
    }

    public void setStarMax(Integer starMax) {
        this.starMax = starMax;
    }

    public Integer getModMin() {
        return modMin;
    }

    public void setModMin(Integer modMin) {
        this.modMin = modMin;
    }

    public Integer getModMax() {
        return modMax;
    }

    public void setModMax(Integer modMax) {
        this.modMax = modMax;
    }

    public Integer getVarMin() {
        return varMin;
    }

    public void setVarMin(Integer varMin) {
        this.varMin = varMin;
    }

    public Integer getVarMax() {
        return varMax;
    }

    public void setVarMax(Integer varMax) {
        this.varMax = varMax;
    }

    public Integer getCrcMin() {
        return crcMin;
    }

    public void setCrcMin(Integer crcMin) {
        this.crcMin = crcMin;
    }

    public Integer getCrcMax() {
        return crcMax;
    }

    public void setCrcMax(Integer crcMax) {
        this.crcMax = crcMax;
    }

    public Integer getMtMin() {
        return mtMin;
    }

    public void setMtMin(Integer mtMin) {
        this.mtMin = mtMin;
    }

    public Integer getMtMax() {
        return mtMax;
    }

    public void setMtMax(Integer mtMax) {
        this.mtMax = mtMax;
    }

    public Integer getgMin() {
        return gMin;
    }

    public void setgMin(Integer gMin) {
        this.gMin = gMin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplyArea() {
        return supplyArea;
    }

    public void setSupplyArea(String supplyArea) {
        this.supplyArea = supplyArea;
    }

    public String getDeliveryManner() {
        return deliveryManner;
    }

    public void setDeliveryManner(String deliveryManner) {
        this.deliveryManner = deliveryManner;
    }

    public String getTotalMoisture() {
        return totalMoisture;
    }

    public void setTotalMoisture(String totalMoisture) {
        this.totalMoisture = totalMoisture;
    }

    public String getMtExp() {
        return mtExp;
    }

    public void setMtExp(String mtExp) {
        this.mtExp = mtExp;
    }

    public String getAshContent() {
        return ashContent;
    }

    public void setAshContent(String ashContent) {
        this.ashContent = ashContent;
    }

    public String getAshBasic() {
        return ashBasic;
    }

    public void setAshBasic(String ashBasic) {
        this.ashBasic = ashBasic;
    }

    public String getAshExp() {
        return ashExp;
    }

    public void setAshExp(String ashExp) {
        this.ashExp = ashExp;
    }

    public String getVolatileMatter() {
        return volatileMatter;
    }

    public void setVolatileMatter(String volatileMatter) {
        this.volatileMatter = volatileMatter;
    }

    public String getVmBasic() {
        return vmBasic;
    }

    public void setVmBasic(String vmBasic) {
        this.vmBasic = vmBasic;
    }

    public String getVmExp() {
        return vmExp;
    }

    public void setVmExp(String vmExp) {
        this.vmExp = vmExp;
    }

    public String getSulfurMatter() {
        return sulfurMatter;
    }

    public void setSulfurMatter(String sulfurMatter) {
        this.sulfurMatter = sulfurMatter;
    }

    public String getSulfurBasic() {
        return sulfurBasic;
    }

    public void setSulfurBasic(String sulfurBasic) {
        this.sulfurBasic = sulfurBasic;
    }

    public String getSulfurExp() {
        return sulfurExp;
    }

    public void setSulfurExp(String sulfurExp) {
        this.sulfurExp = sulfurExp;
    }

    public String getNetCalorificValue() {
        return netCalorificValue;
    }

    public void setNetCalorificValue(String netCalorificValue) {
        this.netCalorificValue = netCalorificValue;
    }

    public String getNcBasic() {
        return ncBasic;
    }

    public void setNcBasic(String ncBasic) {
        this.ncBasic = ncBasic;
    }

    public String getNcExp() {
        return ncExp;
    }

    public void setNcExp(String ncExp) {
        this.ncExp = ncExp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeExp() {
        return sizeExp;
    }

    public void setSizeExp(String sizeExp) {
        this.sizeExp = sizeExp;
    }

    public String getFixedCarbon() {
        return fixedCarbon;
    }

    public void setFixedCarbon(String fixedCarbon) {
        this.fixedCarbon = fixedCarbon;
    }

    public String getFcBasic() {
        return fcBasic;
    }

    public void setFcBasic(String fcBasic) {
        this.fcBasic = fcBasic;
    }

    public String getFcExp() {
        return fcExp;
    }

    public void setFcExp(String fcExp) {
        this.fcExp = fcExp;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getMyRelease() {
        return myRelease;
    }

    public void setMyRelease(String myRelease) {
        this.myRelease = myRelease;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDateS;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDateE;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getQnetarMin() {
        return qnetarMin;
    }

    public void setQnetarMin(Integer qnetarMin) {
        this.qnetarMin = qnetarMin;
    }

    public Integer getQnetarMax() {
        return qnetarMax;
    }

    public void setQnetarMax(Integer qnetarMax) {
        this.qnetarMax = qnetarMax;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }



    public Date getCreateDateS() {
        return createDateS;
    }

    public void setCreateDateS(Date createDateS) {
        this.createDateS = createDateS;
    }

    public Date getCreateDateE() {
        return createDateE;
    }

    public void setCreateDateE(Date createDateE) {
        this.createDateE = createDateE;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQgradMax(Integer qgradMax) {
        this.qgradMax = qgradMax;
    }

    public Integer getQgradMax() {
        return qgradMax;
    }

    public void setQgradMin(Integer qgradMin) {
        this.qgradMin = qgradMin;
    }

    public Integer getQgradMin() {
        return qgradMin;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Integer departureStation) {
        this.departureStation = departureStation;
    }
}
