package com.coalvalue.domain.entity;


import com.coalvalue.domain.BaseDomain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;

/**
 * Created by yuan zhao  on 09/12/2015.
 */
@Entity
@Table(name = "coal_address")
public class CoalAddress extends BaseDomain {

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "line3")
    private String line3;

    @Column(name = "province")
    private String province;

    @Column(name = "prefecture")
    private String prefecture;

    @Column(name = "county")
    private String county;

    @Column(name = "township")
    private String township;

    @Column(name = "zip")
    private String zip;
    private String lat;
    private String lng;

    public CoalAddress() {
    }

    public CoalAddress(String province, String prefecture, String county, String line) {

        this.province = province;
        this.prefecture = prefecture;
        this.county = county;
        this.line1 = line;

    }

    public String getLine1() {
        return line1;
    }
    public String getLine() {
        return line1;
    }
    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public String getProvince() {
        return province;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public String getCounty() {
        return county;
    }

    public String getTownship() {
        return township;
    }

    public String getZip() {
        return zip;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public void setLine(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


    public String toStringAddress() {

        return (this.getProvince()!=null?this.getProvince():"") +","
                + (this.getPrefecture()!=null?this.getPrefecture():"")
                + (this.getCounty()!=null?this.getCounty():"")
                + (this.getTownship()!=null?this.getTownship():"")
                + (this.getLine1()!=null?this.getLine1():"" );

    }

    public String toStringAddressProvincePrefectureCounty() {

        return (this.getProvince()!=null?this.getProvince():"")
                + (this.getPrefecture()!=null?this.getPrefecture():"")
                + (this.getCounty()!=null?this.getCounty():"");

    }

    public String toStringAddressPrefectureCounty() {

        return (this.getPrefecture()!=null?this.getPrefecture():"")
                + (this.getCounty()!=null?this.getCounty():"");

    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String toStringAddressProvincePrefectureCountyTownship() {

        return (this.getProvince()!=null?this.getProvince():"")
                + (this.getPrefecture()!=null?this.getPrefecture():"")
                + (this.getCounty()!=null?this.getCounty():"")
                + (this.getTownship()!=null?this.getTownship():"");

    }
}
