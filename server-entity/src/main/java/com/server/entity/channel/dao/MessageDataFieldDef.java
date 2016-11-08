package com.server.entity.channel.dao;

import java.io.Serializable;

/**
 * 消息字段
 * @author JOHN
 * 2015.01.14
 */
public class MessageDataFieldDef implements Serializable {
    private static final long serialVersionUID = -8610955438761403481L;
    public final static String TYPE_REQ = "REQUEST";
    public final static String TYPE_RESP = "RESPONSE";

    private String id;			//消息字段id
    private String mdDefID;		//MessageDataDef的ID
    private String type;		//消息字段类型
    private String name;		//消息字段名称
    private String dataType;	//消息数据类型
    private String desc;		//消息字段含义

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMdDefID() {
        return mdDefID;
    }
    public void setMdDefID(String mdDefID) {
        this.mdDefID = mdDefID;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

}