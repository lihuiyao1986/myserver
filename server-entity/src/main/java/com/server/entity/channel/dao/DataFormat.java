package com.server.entity.channel.dao;


import com.server.entity.model.BaseDicEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 报文数据域的数据格式
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="DIC_DataFormat")
public class DataFormat extends BaseDicEntity {
    private static final long serialVersionUID = 8528526888259986462L;
    public final static String JSON = "JSON";						//JSON格式
    public final static String XML = "XML";							//XML格式
    public final static String FIXED_LENGTH = "FIXED_LENGTH";		//定长报文
    public final static String VARIABLE_LENGTH = "VARIABLE_LENGTH";	//变长报文
}