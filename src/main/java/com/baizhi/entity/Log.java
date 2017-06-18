package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by gjp06 on 17.6.18.
 */
public class Log {
    private String id;
    private String createUsername;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    private String content;
    private String action;

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", createUsername='" + createUsername + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", action='" + action + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
