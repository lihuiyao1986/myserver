package com.server.user.dao.model;

import javax.persistence.*;

/**
 * UserInfo
 */
@Entity
@Table(name = "T_USER")
public class UserInfo extends BaseDaoModel{

    @Column(name = "T_NAME")
    private String name;

    @Column(name = "T_NICK_NAME")
    private String nickName;

    @Column(name = "T_AGE")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "T_ADDRESS_ID")
    private AddressInfo addressInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
