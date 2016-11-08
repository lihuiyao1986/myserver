package com.server.entity.channel.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 报文数据域定义
 * @author JOHN
 * 2015.01.15
 */
public class MessageDataDef implements Serializable {
    private static final long serialVersionUID = 5245164097437694388L;
    private String id;							//id
    private String servCode;					//服务编码
    private String msgProtocolID;				//MessageProtocol的id，外键关联MessageProtocol
    private String desc;						//描述

    private List<MessageDataFieldDef> reqMsgDataFields;			//请求消息数据域定义
    private List<MessageDataFieldDef> respMsgDataFields;			//请求消息数据域定义

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getServCode() {
        return servCode;
    }
    public void setServCode(String servCode) {
        this.servCode = servCode;
    }
    public String getMsgProtocolID() {
        return msgProtocolID;
    }
    public void setMsgProtocolID(String msgProtocolID) {
        this.msgProtocolID = msgProtocolID;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public List<MessageDataFieldDef> getReqMsgDataFields() {
        return reqMsgDataFields;
    }
    public void setReqMsgDataFields(List<MessageDataFieldDef> reqMsgDataFields) {
        this.reqMsgDataFields = reqMsgDataFields;
    }
    public List<MessageDataFieldDef> getRespMsgDataFields() {
        return respMsgDataFields;
    }
    public void setRespMsgDataFields(List<MessageDataFieldDef> respMsgDataFields) {
        this.respMsgDataFields = respMsgDataFields;
    }

}