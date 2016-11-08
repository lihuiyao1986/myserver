package com.server.entity.channel.dao;

import com.server.entity.model.BaseDicEntity;
import com.server.entity.utils.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 通讯协议
 * 1、TCP/IP
 * 2、WebService
 * 3、暂不支持
 * @author JOHN
 * 2015.01。13
 */
@Entity
@Table(name="DIC_CommProtocol")
public class CommProtocol extends BaseDicEntity {
    private static final long serialVersionUID = 3783857895463478423L;
    public static final String TCP = "TCP"; //TCP通信协议
    public static final String UDP = "UDP"; //UDP通信协议
    public static final String HTTP = "HTTP"; //HTTP通信协议
    //public static final String HTTP_WEIXIN = "HTTP-WX"; //微信通信协议
    public static final String HTTP_REST = "HTTP-REST"; //REST HTTP协议
    public static final String HTTP_WEBSERVIDE = "HTTP-WEBSERVICE"; //WEBSERVICE协议

    public static CommProtocol getCommProtocol(String code){
        CommProtocol commProtocol = new CommProtocol();
        if (TCP.equals(StringUtils.trimNull(code))){
            commProtocol.setId(1);
            commProtocol.setCode(TCP);
        }else if(UDP.equals(StringUtils.trimNull(code))){
            commProtocol.setId(2);
            commProtocol.setCode(UDP);
        }else if(HTTP.equals(StringUtils.trimNull(code))){
            commProtocol.setId(3);
            commProtocol.setCode(HTTP);
        }else if(HTTP_REST.equals(StringUtils.trimNull(code))){
            commProtocol.setId(4);
            commProtocol.setCode(HTTP_REST);
        }else if(HTTP_WEBSERVIDE.equals(StringUtils.trimNull(code))){
            commProtocol.setId(5);
            commProtocol.setCode(HTTP_WEBSERVIDE);
        }
        return commProtocol;
    }
}
