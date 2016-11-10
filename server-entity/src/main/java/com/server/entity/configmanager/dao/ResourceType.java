package com.server.entity.configmanager.dao;

import com.server.entity.utils.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 资源类型
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_ResourceType")
public class ResourceType implements Serializable {
    private static final long serialVersionUID = 5256491572067543058L;
    public static final String SERVICE = "SERVICE";
    public static final String OBJECT = "OBJECT";
    public static final String FILE = "FILE";

    public static ResourceType getResourceType(String code){
        ResourceType type = new ResourceType();
        if (SERVICE.equals(StringUtils.trimNull(code))){
            type.setId(1);
        }else if(OBJECT.equals(StringUtils.trimNull(code))){
            type.setId(2);
        }else if(FILE.equals(StringUtils.trimNull(code))){
            type.setId(3);
        }
        return type;
    }

    @Id
    @Column(length=1)
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;	//id
    @Column(length=20,unique=true,nullable=false)
    private String code;//代码
    @Column(length=50)
    private String description;//描述
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}