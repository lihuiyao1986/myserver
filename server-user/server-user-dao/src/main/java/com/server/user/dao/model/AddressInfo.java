package com.server.user.dao.model;

import javax.persistence.*;

/**
 * Created by jk on 16/11/7.
 */
@Entity
@Table(name = "T_ADDRESS")
public class AddressInfo extends BaseDaoModel {

    @Column(name = "T_ADDRESS_NAME",nullable = false)
    private String addressName;

    @Column(name = "T_CITY_NAME")
    private String cityName;

    @Column(name = "T_CITY_CODE")
    private String cityCode;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE},targetEntity = UserInfo.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "T_USER_ID",referencedColumnName = "T_ID")
    private UserInfo userInfo;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "addressName='" + addressName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }
}
