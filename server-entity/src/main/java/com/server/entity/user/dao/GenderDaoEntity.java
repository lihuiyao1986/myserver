package com.server.entity.user.dao;

import com.server.entity.model.BaseDicEntity;
import com.server.entity.utils.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by jk on 16/11/8.
 */
@Entity
@Table(name="DIC_Gender")
public class GenderDaoEntity extends BaseDicEntity {

    private static final long serialVersionUID = -7792595446621666866L;
    public final static String MALE = "MALE";		//男
    public final static String FEMALE = "FEMALE";		//女
    public final static String NONE = "NONE";		//未知

    public static GenderDaoEntity getGender(String code){
        GenderDaoEntity gender = new GenderDaoEntity();
        if (MALE.equals(StringUtils.trimNull(code))){
            gender.setId(1);
        }else if (FEMALE.equals(StringUtils.trimNull(code))){
            gender.setId(2);
        }else{
            gender.setId(3);
        }
        return gender;
    }
}
