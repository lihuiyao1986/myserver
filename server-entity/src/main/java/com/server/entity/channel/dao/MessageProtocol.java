package com.server.entity.channel.dao;

import com.server.entity.model.BaseDicEntity;

import javax.persistence.*;
import java.util.Map;

/**
 * 消息协议
 * @author JOHN
 * 2015.01.15
 */
@Entity
@Table(name="BIZ_MessageProtocol")
public class MessageProtocol extends BaseDicEntity {
    private static final long serialVersionUID = -8200699854916754089L;
    @Transient
    public static final String STANDAD = "STANDAD"; //内置标准消息协议
    @Transient
    public static final String ENESYS = "ENESYS"; //ENESYS消息解析协议
    @Transient
    public static final String ENESYSV2 = "ENESYSV2"; //ENESYSV2消息解析协议
    @Transient
    public static final String ALIPAY = "ALIPAY"; 	//支付宝服务窗消息解析协议
    @Transient
    public static final String WEIXIN = "WEIXIN"; 	//微信公众服务平台消息解析协议
    @Transient
    public static final String CLOUDCOMM = "CLOUDCOMM"; 	//云通讯消息解析协议
    @Transient
    public static final String P8583 = "8583"; 		//8583报文
    @Transient
    public static final String EMAIL = "EMAIL"; 		//邮箱
    @Transient
    public static final String SINAWEIBO = "SINAWEIBO"; //新浪微博

    @Column
    private byte startSymbol = 0x68;						//起始符号
    @Column
    private byte endSymbol = 0x16;							//结束符号
    @Column
    private int dataLengthLength = 4;				//数据域字节数所占长度，单位是4
    @Column
    private int servCodeLength = 6;					//交易代码所占长度，单位是byte
    @Column
    private int signLength = 0;						//数字签名所占长度，，单位是byte
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=true)
    @JoinColumn
    private SignAlgorithm signAlgorithm;			//签名算法

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private DataFormat dataFormat;					//数据格式
    @Column(length=50)
    private String processorClassName;				//对数据进行处理的处理器类名称

    @Transient
    private Map<String, MessageDataDef> dataDef;	//该消息协议下所有报文的报文数据域定义：<交易代码，报文数据域定义>

    //该消息协议，是否允许创建菜单
    @Column
    private boolean allowMenu;
    //该消息协议，是否将分组同步至第三方平台
    @Column
    private boolean syncGroup;
    //该消息协议，是否允许发送消息
    @Column
    private boolean allowMessage;


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

    public byte getStartSymbol() {
        return startSymbol;
    }

    public void setStartSymbol(byte startSymbol) {
        this.startSymbol = startSymbol;
    }

    public byte getEndSymbol() {
        return endSymbol;
    }

    public void setEndSymbol(byte endSymbol) {
        this.endSymbol = endSymbol;
    }

    public int getDataLengthLength() {
        return dataLengthLength;
    }

    public void setDataLengthLength(int dataLengthLength) {
        this.dataLengthLength = dataLengthLength;
    }

    public int getServCodeLength() {
        return servCodeLength;
    }

    public void setServCodeLength(int servCodeLength) {
        this.servCodeLength = servCodeLength;
    }

    public int getSignLength() {
        return signLength;
    }

    public void setSignLength(int signLength) {
        this.signLength = signLength;
    }

    public SignAlgorithm getSignAlgorithm() {
        return signAlgorithm;
    }

    public void setSignAlgorithm(SignAlgorithm signAlgorithm) {
        this.signAlgorithm = signAlgorithm;
    }

    public DataFormat getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(DataFormat dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getProcessorClassName() {
        return processorClassName;
    }

    public void setProcessorClassName(String processorClassName) {
        this.processorClassName = processorClassName;
    }

    public Map<String, MessageDataDef> getDataDef() {
        return dataDef;
    }

    public void setDataDef(Map<String, MessageDataDef> dataDef) {
        this.dataDef = dataDef;
    }
    public boolean isAllowMenu() {
        return allowMenu;
    }

    public boolean isSyncGroup() {
        return syncGroup;
    }

    public boolean isAllowMessage() {
        return allowMessage;
    }

    public void setAllowMenu(boolean allowMenu) {
        this.allowMenu = allowMenu;
    }

    public void setSyncGroup(boolean syncGroup) {
        this.syncGroup = syncGroup;
    }

    public void setAllowMessage(boolean allowMessage) {
        this.allowMessage = allowMessage;
    }

}
