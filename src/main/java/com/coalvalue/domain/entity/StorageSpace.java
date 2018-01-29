package com.coalvalue.domain.entity;

import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by yuan zhao  on 08/10/2015.
 */

@Entity

@Table(name = "storage_space")

public class StorageSpace extends BaseDomain {



    @Column(name = "name")
    private String name;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "no")
    private String no;

    @Column(name = "lng")
    private String lng;

    @Column(name = "bd09Lat")
    private String bd09Lat;


    @Column(name = "bd09Lng")
    private String bd09Lng;

    @Column(name = "lat")
    private String lat;


    private String province;
    private String city;

    private String district;
    private String street;

    private Integer pendingCount;
    private Integer loadingCount;
    @Transient
    private String agent;
    private Integer districtId;
    private String type;

    private Boolean major;
    private Integer collaboratorId;


    public Boolean isMajor() {
        return major;
    }

    public void setMajor(Boolean major) {
        this.major = major;
    }

    public Integer getLoadingCount() {
        return loadingCount;
    }

    public void setLoadingCount(Integer loadingCount) {
        this.loadingCount = loadingCount;
    }

    public Integer getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(Integer pendingCount) {
        this.pendingCount = pendingCount;
    }

    @Column(name = "street_number")
    private String streetNumber;
    @Transient
    private long waitingOperationCount;
    @Transient
    private long loadingOperationCount;


    @Column(name = "associated_storage_id")
    private Integer associatedStorageId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAssociatedStorageId() {
        return associatedStorageId;
    }

    public void setAssociatedStorageId(Integer associatedStorageId) {
        this.associatedStorageId = associatedStorageId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public StorageSpace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getBd09Lat() {
        return bd09Lat;
    }

    public void setBd09Lat(String bd09Lat) {
        this.bd09Lat = bd09Lat;
    }

    public String getBd09Lng() {
        return bd09Lng;
    }

    public void setBd09Lng(String bd09Lng) {
        this.bd09Lng = bd09Lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }




    public String getLocationString(){

        return province +" " +city + " " +district+ " " + street+ " " + streetNumber;
    }
    public void setCountOperationsCreated(long waitingOperationCount) {
        this.waitingOperationCount = waitingOperationCount;
    }

    public long getWaitingOperationCount() {
        return waitingOperationCount;
    }

    public void setCountOperationsLoading(long loadingOperationCount) {
        this.loadingOperationCount = loadingOperationCount;
    }

    public long getLoadingOperationCount() {
        return loadingOperationCount;
    }

    public String getProvinceCityDistrictString() {
        return getProvince() + getCity()+getDistrict();
    }


    public String getProvinceCityDistrictStreetString() {
        return getProvince() + getCity()+getDistrict()+getStreet();
    }

    public boolean aanBeAddPrincipals() {
        return true;
    }

    public boolean canAssocatied() {
        return true;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }




    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCollaboratorId(Integer collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public Integer getCollaboratorId() {
        return collaboratorId;
    }
}
