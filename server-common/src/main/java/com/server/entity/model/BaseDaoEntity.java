package com.server.entity.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * BaseDaoModel
 */
@MappedSuperclass
public class BaseDaoEntity implements Serializable {

    private static final long serialVersionUID = 5564472672113187720L;

    @Id
    @Column(name = "T_ID")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
