package org.lanqiao.model;

import java.io.Serializable;
import java.util.List;

public class Power implements Serializable {
    private String powerId;
    private String powerName;
    private String powerComment;
    private String powerUrl;
    private String powerFather;
    private Integer powerType;
    private String params;
    private Byte status;
    private List<Power> powerChild;

    @Override
    public String toString() {
        return "Power{" +
                "powerId='" + powerId + '\'' +
                ", powerName='" + powerName + '\'' +
                ", powerComment='" + powerComment + '\'' +
                ", powerUrl='" + powerUrl + '\'' +
                ", powerFather='" + powerFather + '\'' +
                ", powerType=" + powerType +
                ", params='" + params + '\'' +
                ", status=" + status +
                ", powerChild=" + powerChild +
                '}';
    }

    public void setPowerChild(List<Power> powerChild) {
        this.powerChild = powerChild;
    }

    public List<Power> getPowerChild() {
        return powerChild;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParams() {
        return params;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public void setPowerComment(String powerComment) {
        this.powerComment = powerComment;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }

    public void setPowerFather(String powerFather) {
        this.powerFather = powerFather;
    }

    public String getPowerId() {
        return powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public String getPowerComment() {
        return powerComment;
    }

    public String getPowerUrl() {
        return powerUrl;
    }

    public String getPowerFather() {
        return powerFather;
    }

    public void setPowerType(Integer powerType) {
        this.powerType = powerType;
    }

    public Integer getPowerType() {
        return powerType;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

}
