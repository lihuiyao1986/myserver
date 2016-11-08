package com.server.user.dao.model;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE},targetEntity = AddressInfo.class,fetch = FetchType.EAGER)
    private Set<AddressInfo> addressInfos;

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

    public Set<AddressInfo> getAddressInfos() {
        return addressInfos;
    }

    public void setAddressInfos(Set<AddressInfo> addressInfos) {
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
