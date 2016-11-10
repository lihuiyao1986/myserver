package com.server.entity.configmanager.web.resp;

import java.io.Serializable;
import java.util.List;

/**
 * 用户权限
 */
public class UserRight implements Serializable{

    private static final long serialVersionUID = -5502324456816425171L;

    private String code;

    private String rightName;

    private String url;

    List<UserRight> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<UserRight> getChildren() {
        return children;
    }

    public void setChildren(List<UserRight> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "UserRight{" +
                "code='" + code + '\'' +
                ", rightName='" + rightName + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
