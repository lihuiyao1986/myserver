package com.server.user.api.model;

import com.server.user.dao.model.AddressInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by jk on 16/11/6.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    private static final long serialVersionUID = 2508320148658156845L;

    private String name;

    private long age;

    private String nickname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private Set<AddressInfo> addressInfos;

    public Set<AddressInfo> getAddressInfos() {
        return addressInfos;
    }

    public void setAddressInfos(Set<AddressInfo> addressInfos) {
        this.addressInfos = addressInfos;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
