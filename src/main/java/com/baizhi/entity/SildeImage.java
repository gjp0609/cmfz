package com.baizhi.entity;

import java.util.Date;

/**
 * Created by gjp06 on 17.6.13.
 */
public class SildeImage {
    private String id;
    private String detail;
    private String src;
    private Date createTime;
    private Date updateTime;
    private String status;

    @Override
    public String toString() {
        return "SildeImage{" +
                "id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                ", src='" + src + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
