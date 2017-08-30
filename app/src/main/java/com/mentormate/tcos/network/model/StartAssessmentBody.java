package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StartAssessmentBody {
    @SerializedName("UserId")
    @Expose
    public String userId;
    @SerializedName("Organizations")
    @Expose
    public List<String> organizations = new ArrayList<>();
    @SerializedName("PropertyId")
    @Expose
    public String propertyId;
    @SerializedName("AssessmentId")
    @Expose
    public String assessmentId;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("PoiList")
    @Expose
    public List<PoiList> poiList = new ArrayList<>();
    @SerializedName("Description")
    @Expose
    public String description;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<String> organizations) {
        this.organizations = organizations;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PoiList> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiList> poiList) {
        this.poiList = poiList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StartAssessmentBody{" +
                "userId='" + userId + '\'' +
                ", organizations=" + organizations +
                ", propertyId='" + propertyId + '\'' +
                ", assessmentId='" + assessmentId + '\'' +
                ", name='" + name + '\'' +
                ", poiList=" + poiList +
                ", description='" + description + '\'' +
                '}';
    }
}
