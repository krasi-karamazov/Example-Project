package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiWork {
    @SerializedName("ProjectId")
    @Expose
    private String projectId;
    @SerializedName("LayoutId")
    @Expose
    private String layoutId;
    @SerializedName("Coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("PoiNumber")
    @Expose
    private int poiNumber;
    @SerializedName("PoiName")
    @Expose
    private String poiName;
    @SerializedName("PoiCategory")
    @Expose
    private PoiCategory poiCategory;
    @SerializedName("LastModifiedDate")
    @Expose
    private String lastModifiedDate;
    @SerializedName("ProjectStatus")
    @Expose
    private String projectStatus;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getPoiNumber() {
        return poiNumber;
    }

    public void setPoiNumber(int poiNumber) {
        this.poiNumber = poiNumber;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public PoiCategory getPoiCategory() {
        return poiCategory;
    }

    public void setPoiCategory(PoiCategory poiCategory) {
        this.poiCategory = poiCategory;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "PoiWork{" +
                "projectId='" + projectId + '\'' +
                ", layoutId='" + layoutId + '\'' +
                ", coordinates=" + coordinates +
                ", poiNumber=" + poiNumber +
                ", poiName='" + poiName + '\'' +
                ", poiCategory=" + poiCategory +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
}
