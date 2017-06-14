package com.baizhi.entity;

/**
 * Created by gjp06 on 17.6.14.
 */
public class Lama {
    private String id;
    private String lamaName;
    private String src;

    @Override
    public String toString() {
        return "Lama{" +
                "id='" + id + '\'' +
                ", lamaName='" + lamaName + '\'' +
                ", src='" + src + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLamaName() {
        return lamaName;
    }

    public void setLamaName(String lamaName) {
        this.lamaName = lamaName;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
