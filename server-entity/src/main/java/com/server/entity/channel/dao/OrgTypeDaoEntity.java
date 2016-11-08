package com.server.entity.channel.dao;

import com.server.entity.model.BaseDicEntity;
import com.server.entity.utils.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *部门类型
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_OrgType")
public class OrgTypeDaoEntity extends BaseDicEntity {

    public static final String GENERAL_COMPANY = "GENERAL COMPANY";			//一般公司

    public static final String GROUP_COMPANY = "GROUP COMPANY";				//集团公司

    public static final String BRANCH_COMPANY = "BRANCH COMPANY";			//分公司

    public static final String SUBSIDIARY_COMPANY = "SUBSIDIARY COMPANY";	//子公司

    public static final String DEPARTMENT = "DEPARTMENT";					//部门

    public static OrgTypeDaoEntity getOrgType(String code){
        OrgTypeDaoEntity type = new OrgTypeDaoEntity();
        if (GENERAL_COMPANY.equals(StringUtils.trimNull(code))){
            type.setId(1);
        }else if (GROUP_COMPANY.equals(StringUtils.trimNull(code))){
            type.setId(2);
        }else if (BRANCH_COMPANY.equals(StringUtils.trimNull(code))){
            type.setId(3);
        }else if (SUBSIDIARY_COMPANY.equals(StringUtils.trimNull(code))){
            type.setId(4);
        }else if (DEPARTMENT.equals(StringUtils.trimNull(code))){
            type.setId(5);
        }
        return type;
    }
}
