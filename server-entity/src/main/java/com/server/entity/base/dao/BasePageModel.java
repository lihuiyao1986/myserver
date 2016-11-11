package com.server.entity.base.dao;

import com.server.entity.model.BaseModel;

/**
 * BasePageModel
 */
public class BasePageModel extends BaseModel {

    // 页码
    private int pageNo;

    // 每页记录数
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BasePageModel{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
