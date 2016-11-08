package com.server.entity.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;

/**
 * Created by jk on 16/11/8.
 */
@MappedSuperclass
public class BaseBizEntity extends BaseDaoEntity {

    @Column
    protected Date createDate;			//对象创建时间

    @Column
    protected Date lastUpdateDate;		//对象最后修改时间

    @Column(length=20,nullable=false)
    protected String ownership;	//所属组织的code

    @Version
    @Column(columnDefinition="int default 0")
    protected int version;						//版本号

    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
