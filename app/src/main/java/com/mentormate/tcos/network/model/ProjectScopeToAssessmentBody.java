package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProjectScopeToAssessmentBody {

    @SerializedName("UserId")
    @Expose
    private String userId;
    @SerializedName("Organizations")
    @Expose
    private List<String> organizations = new ArrayList<>();
    @SerializedName("AssessmentId")
    @Expose
    private String assessmentId;
    @SerializedName("PropertyId")
    @Expose
    private String propertyId;
    @SerializedName("PoiList")
    @Expose
    private List<PoiList> poiList = new ArrayList<>();

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

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public List<PoiList> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiList> poiList) {
        this.poiList = poiList;
    }

    @Override
    public String toString() {
        return "ProjectScopeToAssessmentBody{" +
                "userId='" + userId + '\'' +
                ", organizations=" + organizations +
                ", assessmentId='" + assessmentId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", poiList=" + poiList +
                '}';
    }
}
