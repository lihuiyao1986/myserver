package com.server.entity.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * BaseDaoModel
 */
@MappedSuperclass
public class BaseDaoEntity extends BaseModel {

    private static final long serialVersionUID = 5564472672113187720L;

    @Id
    @Column(length=3)
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    protected int id;	//id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
