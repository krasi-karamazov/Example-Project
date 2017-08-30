package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProjectJob extends BaseJobModel {

    @SerializedName("Description")
    @Expose
    public String description;

    @SerializedName("PropertyId")
    @Expose
    public String propertyId;
    @SerializedName("PoiWorks")
    @Expose
    public List<PoiWork> poiWorks = new ArrayList<>();
    @SerializedName("PoiWorkCount")
    @Expose
    public int poiWorkCount;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PoiWork> getPoiWorks() {
        return poiWorks;
    }

    public void setPoiWorks(List<PoiWork> poiWorks) {
        this.poiWorks = poiWorks;
    }

    public int getPoiWorkCount() {
        return poiWorkCount;
    }

    public void setPoiWorkCount(int poiWorkCount) {
        this.poiWorkCount = poiWorkCount;
    }

    @Override
    public String toString() {
        return "ProjectJob{" +
                "description='" + description + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", poiWorks=" + poiWorks +
                ", poiWorkCount=" + poiWorkCount +
                '}';
    }
}
