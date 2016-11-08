package com.server.entity.channel.dao;

import com.server.entity.model.BaseBizEntity;
import com.server.entity.user.dao.Participant;

import javax.persistence.*;

/**
 * 服务点，组织在此服务点对外提供服务
 * @author JOHN
 * 2015.01.13
 */
@Entity
@Table(name="BIZ_ServicePoint")
public class ServicePoint extends BaseBizEntity {
    private static final long serialVersionUID = 8229834879652590132L;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private Participant owner;				//服务点对应的组织机构id，外键关联Participant

    @Column(length=50)
    private String workDir; 				//服务点工作目录

    @Transient
    private String name;

    @Column(length=10)
    private String bankCode;              //银行号

    //本地通信配置
    @Column(length=20)
    private String localIP;					//服务点本地代理IP地址
    @Column(unique=true)
    private int localPort;					//服务点本地代理端口号
    //通讯协议
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private CommProtocol localCommProtocol;		//通讯协议

    @Column
    private boolean localSslEnabled;				//通道是否采用加密
    @Column(length=10)
    private String localSslProtocol = "SSL";		//socket使用的加密/解密协议。如果使用的是Sun的JVM，则不建议改变这个值。
    @Column(length=20)
    private String localTrustMgrAlgorithm = "SunX509";	//使用的X509算法。缺省为Sun的实现（SunX509）。对于IBM JVMS应该使用ibmX509
    @Column(length=10)
    private String localKeystoreType = "JKS";	//如果使用了一个PKCS12 keystore，加入该属性。有效值是JKS和PKCS12。
    @Column(length=100)
    private String localKeystoreFile = "F:/key/kserver.keystore";			//客户端私钥
    @Column(length=20)
    private String localKeystorePass = "longshine";			//客户端私钥密码
    @Column(length=20)
    private String localKeyAlias = "longshine";
    @Column(length=20)
    private String localKeyAliasPass = "longshine";
    @Column(length=100)
    private String localTruststoreFile = "F:/key/tserver.keystore";			//用来验证客户证书的TrustStore文件。
    @Column(length=20)
    private String localTruststorePass = "longshine";			//访问TrustStore使用的密码。缺省值是keystorePass。
    @Column(length=20)
    private String localTrustKeyAlias = "longshine";
    @Column(length=20)
    private String localTrusKeyAliasPass = "longshine";
    @Column
    private boolean localNeedClientAuth;			//是否需要客户端要认证
    @Column
    private boolean localStartTlsEnabled;			//是否启用startTls
    //消息协议
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private MessageProtocol localMsgProtocol;		//消息协议

    //远程通讯配置
    @Column(length=20)
    private String remoteIP;				//服务点远端IP地址
    @Column
    private int remotePort;					//服务点远端端口号
    @Column(length=20)
    private String remoteCode;					//服务点远端编号
    //通讯协议
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn(nullable=false)
    private CommProtocol remoteCommProtocol;		//通讯协议
    @Column
    private boolean remoteSslEnabled;				//通道是否采用加密
    @Column(length=10)
    private String remoteSslProtocol = "SSL";		//socket使用的加密/解密协议。如果使用的是Sun的JVM，则不建议改变这个值。
    @Column(length=20)
    private String remoteTrustMgrAlgorithm = "SunX509";	//使用的X509算法。缺省为Sun的实现（SunX509）。对于IBM JVMS应该使用ibmX509
    @Column(length=10)
    private String remoteKeystoreType = "JKS";	//如果使用了一个PKCS12 keystore，加入该属性。有效值是JKS和PKCS12。
    @Column(length=100)
    private String remoteKeystoreFile;			//客户端私钥
    @Column(length=20)
    private String remoteKeystorePass ;			//客户端私钥密码
    @Column(length=20)
    private String remoteKeyAlias;
    @Column(length=20)
    private String remoteKeyAliasPass;
    @Column(length=100)
    private String remoteTruststoreFile;			//用来验证客户证书的TrustStore文件。
    @Column(length=20)
    private String remoteTruststorePass;			//访问TrustStore使用的密码。缺省值是keystorePass。
    @Column(length=20)
    private String remoteTrustKeyAlias;
    @Column(length=20)
    private String remoteTrustKeyAliasPass;
    //消息协议
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private MessageProtocol remoteMsgProtocol;		//消息协议

    @Column
    private int maxConnection; 				//该服务点最大连接数

    @Column
    private String  servBgnTime;				//服务开放开始时间,hh24mmss
    @Column
    private String  servEndTime;				//服务开放截止时间，hh24mmss

    @Column
    private boolean acEnabled;				//打开访问控制

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false,fetch = FetchType.EAGER)
    @JoinColumn
    private ServiceStatus status;			//服务点状态

    //远端访问Appid
    @Column(length=20)
    private String remoteAppId;
    //远端访问密钥
    @Column(length=50)
    private String remoteAppSecret;
    //用于区别同一消息协议，不同地址    默认为空:访问usmart接口   IOT2.4:访问金卡物联网2.4接口
    @Column(length=20)
    private String remoteUriType;


    /**
     * 获得sp的详细描述
     * @return
     */
    public String getDesc() {
        if(owner != null){
            return "<" + owner.getName() + "(code:" + owner.getCode()
                    + ",port:" + localPort + ")>";
        }else{
            return "";
        }

    }

    public Participant getOwner() {
        return owner;
    }
    public void setOwner(Participant org) {
        this.owner = org;
    }

    public String getName() {
        if(owner != null && localMsgProtocol != null){
            return owner.getName()+"-"+localMsgProtocol.getDescription();
        }else{
            return "89";
        }

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getWorkDir() {
        return workDir;
    }
    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }
    public String getLocalIP() {
        return localIP;
    }
    public void setLocalIP(String localIP) {
        this.localIP = localIP;
    }
    public int getLocalPort() {
        return localPort;
    }
    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }
    public boolean isLocalSslEnabled() {
        return localSslEnabled;
    }
    public void setLocalSslEnabled(boolean localSslEnabled) {
        this.localSslEnabled = localSslEnabled;
    }
    public String getLocalSslProtocol() {
        return localSslProtocol;
    }
    public void setLocalSslProtocol(String localSslProtocol) {
        this.localSslProtocol = localSslProtocol;
    }
    public String getLocalKeystoreFile() {
        return localKeystoreFile;
    }
    public void setLocalKeystoreFile(String localKeystoreFile) {
        this.localKeystoreFile = localKeystoreFile;
    }
    public String getLocalKeystorePass() {
        return localKeystorePass;
    }
    public void setLocalKeystorePass(String localKeystorePass) {
        this.localKeystorePass = localKeystorePass;
    }
    public String getLocalKeystoreType() {
        return localKeystoreType;
    }
    public void setLocalKeystoreType(String localKeystoreType) {
        this.localKeystoreType = localKeystoreType;
    }
    public String getLocalTruststoreFile() {
        return localTruststoreFile;
    }
    public void setLocalTruststoreFile(String localTruststoreFile) {
        this.localTruststoreFile = localTruststoreFile;
    }
    public String getLocalTruststorePass() {
        return localTruststorePass;
    }
    public void setLocalTruststorePass(String localTruststorePass) {
        this.localTruststorePass = localTruststorePass;
    }
    public MessageProtocol getLocalMsgProtocol() {
        return localMsgProtocol;
    }
    public void setLocalMsgProtocol(MessageProtocol localMsgProtocol) {
        this.localMsgProtocol = localMsgProtocol;
    }
    public String getRemoteIP() {
        return remoteIP;
    }
    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }
    public int getRemotePort() {
        return remotePort;
    }
    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }
    public CommProtocol getRemoteCommProtocol() {
        return remoteCommProtocol;
    }
    public void setRemoteCommProtocol(CommProtocol remoteCommProtocol) {
        this.remoteCommProtocol = remoteCommProtocol;
    }
    public boolean isRemoteSslEnabled() {
        return remoteSslEnabled;
    }
    public void setRemoteSslEnabled(boolean remoteSslEnabled) {
        this.remoteSslEnabled = remoteSslEnabled;
    }
    public String getRemoteSslProtocol() {
        return remoteSslProtocol;
    }
    public void setRemoteSslProtocol(String remoteSslProtocol) {
        this.remoteSslProtocol = remoteSslProtocol;
    }
    public String getRemoteKeystoreFile() {
        return remoteKeystoreFile;
    }
    public void setRemoteKeystoreFile(String remoteKeystoreFile) {
        this.remoteKeystoreFile = remoteKeystoreFile;
    }
    public String getRemoteKeystorePass() {
        return remoteKeystorePass;
    }
    public void setRemoteKeystorePass(String remoteKeystorePass) {
        this.remoteKeystorePass = remoteKeystorePass;
    }
    public String getRemoteKeystoreType() {
        return remoteKeystoreType;
    }
    public void setRemoteKeystoreType(String remoteKeystoreType) {
        this.remoteKeystoreType = remoteKeystoreType;
    }
    public String getRemoteTruststoreFile() {
        return remoteTruststoreFile;
    }
    public void setRemoteTruststoreFile(String remoteTruststoreFile) {
        this.remoteTruststoreFile = remoteTruststoreFile;
    }
    public String getRemoteTruststorePass() {
        return remoteTruststorePass;
    }
    public void setRemoteTruststorePass(String remoteTruststorePass) {
        this.remoteTruststorePass = remoteTruststorePass;
    }
    public MessageProtocol getRemoteMsgProtocol() {
        return remoteMsgProtocol;
    }
    public void setRemoteMsgProtocol(MessageProtocol remoteMsgProtocol) {
        this.remoteMsgProtocol = remoteMsgProtocol;
    }
    public int getMaxConnection() {
        return maxConnection;
    }
    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }
    public ServiceStatus getStatus() {
        return status;
    }
    public void setStatus(ServiceStatus status) {
        this.status = status;
    }



    public String getServBgnTime() {
        return servBgnTime;
    }

    public void setServBgnTime(String servBgnTime) {
        this.servBgnTime = servBgnTime;
    }

    public String getServEndTime() {
        return servEndTime;
    }

    public void setServEndTime(String servEndTime) {
        this.servEndTime = servEndTime;
    }

    public CommProtocol getLocalCommProtocol() {
        return localCommProtocol;
    }
    public void setLocalCommProtocol(CommProtocol localCommProtocol) {
        this.localCommProtocol = localCommProtocol;
    }
    //	public Set<Service> getServices() {
//		return services;
//	}
//	public void setServices(Set<Service> services) {
//		this.services = services;
//	}
    public String getLocalTrustMgrAlgorithm() {
        return localTrustMgrAlgorithm;
    }
    public void setLocalTrustMgrAlgorithm(String localTrustMgrAlgorithm) {
        this.localTrustMgrAlgorithm = localTrustMgrAlgorithm;
    }
    public String getRemoteTrustMgrAlgorithm() {
        return remoteTrustMgrAlgorithm;
    }
    public void setRemoteTrustMgrAlgorithm(String remoteTrustMgrAlgorithm) {
        this.remoteTrustMgrAlgorithm = remoteTrustMgrAlgorithm;
    }
    public boolean isLocalNeedClientAuth() {
        return localNeedClientAuth;
    }
    public void setLocalNeedClientAuth(boolean localNeedClientAuth) {
        this.localNeedClientAuth = localNeedClientAuth;
    }
    public boolean isLocalStartTlsEnabled() {
        return localStartTlsEnabled;
    }
    public void setLocalStartTlsEnabled(boolean localStartTlsEnabled) {
        this.localStartTlsEnabled = localStartTlsEnabled;
    }
    public String getLocalKeyAlias() {
        return localKeyAlias;
    }
    public void setLocalKeyAlias(String localKeyAlias) {
        this.localKeyAlias = localKeyAlias;
    }
    public String getLocalKeyAliasPass() {
        return localKeyAliasPass;
    }
    public void setLocalKeyAliasPass(String localKeyAliasPass) {
        this.localKeyAliasPass = localKeyAliasPass;
    }
    public String getLocalTrustKeyAlias() {
        return localTrustKeyAlias;
    }
    public void setLocalTrustKeyAlias(String localTrustKeyAlias) {
        this.localTrustKeyAlias = localTrustKeyAlias;
    }
    public String getLocalTrusKeyAliasPass() {
        return localTrusKeyAliasPass;
    }
    public void setLocalTrusKeyAliasPass(String localTrusKeyAliasPass) {
        this.localTrusKeyAliasPass = localTrusKeyAliasPass;
    }
    public String getRemoteKeyAlias() {
        return remoteKeyAlias;
    }
    public void setRemoteKeyAlias(String remoteKeyAlias) {
        this.remoteKeyAlias = remoteKeyAlias;
    }
    public String getRemoteTrustKeyAlias() {
        return remoteTrustKeyAlias;
    }
    public void setRemoteTrustKeyAlias(String remoteTrustKeyAlias) {
        this.remoteTrustKeyAlias = remoteTrustKeyAlias;
    }
    public String getRemoteTrustKeyAliasPass() {
        return remoteTrustKeyAliasPass;
    }
    public void setRemoteTrustKeyAliasPass(String remoteTrustKeyAliasPass) {
        this.remoteTrustKeyAliasPass = remoteTrustKeyAliasPass;
    }
    public String getRemoteKeyAliasPass() {
        return remoteKeyAliasPass;
    }
    public void setRemoteKeyAliasPass(String remoteKeyAliasPass) {
        this.remoteKeyAliasPass = remoteKeyAliasPass;
    }
    public boolean isAcEnabled() {
        return acEnabled;
    }
    public void setAcEnabled(boolean acEnabled) {
        this.acEnabled = acEnabled;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public String getRemoteCode() {
        return remoteCode;
    }

    public void setRemoteCode(String remoteCode) {
        this.remoteCode = remoteCode;
    }

    public String getRemoteAppId() {
        return remoteAppId;
    }

    public void setRemoteAppId(String remoteAppId) {
        this.remoteAppId = remoteAppId;
    }
    public String getRemoteAppSecret() {
        return remoteAppSecret;
    }

    public void setRemoteAppSecret(String remoteAppSecret) {
        this.remoteAppSecret = remoteAppSecret;
    }

    public String getRemoteUriType() {
        return remoteUriType;
    }

    public void setRemoteUriType(String remoteUriType) {
        this.remoteUriType = remoteUriType;
    }

}
