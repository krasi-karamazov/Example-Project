package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin {
    @SerializedName("OriginId")
    @Expose
    public String originId;
    @SerializedName("OriginType")
    @Expose
    public String originType;
    @SerializedName("OriginContent")
    @Expose
    public OriginContent originContent;


    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getOriginType() {
        return originType;
    }

    public void setOriginType(String originType) {
        this.originType = originType;
    }

    public OriginContent getOriginContent() {
        return originContent;
    }

    public void setOriginContent(OriginContent originContent) {
        this.originContent = originContent;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "originId='" + originId + '\'' +
                ", originType='" + originType + '\'' +
                ", originContent=" + originContent +
                '}';
    }
}
