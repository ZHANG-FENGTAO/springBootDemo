package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

public class SiteBean implements Serializable {
    private String id;

    private String name;

    private Integer status;

    private Integer isDel;

    private Date addDate;

    private Double lat;

    private Double lng;

    private String fullName;

    private Integer shopShutStatus;

    private Integer shopSwitch;

    private String phone;

    private String address;

    private Integer areaId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Integer getShopShutStatus() {
        return shopShutStatus;
    }

    public void setShopShutStatus(Integer shopShutStatus) {
        this.shopShutStatus = shopShutStatus;
    }

    public Integer getShopSwitch() {
        return shopSwitch;
    }

    public void setShopSwitch(Integer shopSwitch) {
        this.shopSwitch = shopSwitch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}