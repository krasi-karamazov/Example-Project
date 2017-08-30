package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiLayout {
    @SerializedName("Id")
    @Expose
    public String id;

    @SerializedName("Name")
    @Expose
    public String name;

    @SerializedName("LayoutId")
    @Expose
    public String layoutId;

    @SerializedName("PropertyId")
    @Expose
    public String propertyId;

    @SerializedName("IsDeleted")
    @Expose
    public boolean isDeleted;

    @SerializedName("RenderInfo")
    @Expose
    public RenderInfo renderInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RenderInfo getRenderInfo() {
        return renderInfo;
    }

    public void setRenderInfo(RenderInfo renderInfo) {
        this.renderInfo = renderInfo;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "PoiLayout{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", layoutId='" + layoutId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", isDeleted=" + isDeleted +
                ", renderInfo=" + renderInfo +
                '}';
    }
}
