package com.server.user.dao.model;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userInfo")
    private List<AddressInfo> addressInfos;

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

    public List<AddressInfo> getAddressInfos() {
        return addressInfos;
    }

    public void setAddressInfos(List<AddressInfo> addressInfos) {
        this.addressInfos = addressInfos;
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
