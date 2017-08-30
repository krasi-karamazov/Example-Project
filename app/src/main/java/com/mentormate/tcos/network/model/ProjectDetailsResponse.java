package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetailsResponse {
    @SerializedName("OriginId")
    @Expose
    public String originId;
    @SerializedName("ProjectNumber")
    @Expose
    public int projectNumber;
    @SerializedName("ProjectName")
    @Expose
    public String projectName;
    @SerializedName("ProjectStatus")
    @Expose
    public Object projectStatus;
    @SerializedName("Layout")
    @Expose
    public PoiLayout layout;
    @SerializedName("PropertyName")
    @Expose
    public String propertyName;
    @SerializedName("Revisions")
    @Expose
    public List<Revision> revisions = new ArrayList<>();
    @SerializedName("LastModifiedDate")
    @Expose
    public String lastModifiedDate;


    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Object getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Object projectStatus) {
        this.projectStatus = projectStatus;
    }

    public PoiLayout getLayout() {
        return layout;
    }

    public void setLayout(PoiLayout layout) {
        this.layout = layout;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public List<Revision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<Revision> revisions) {
        this.revisions = revisions;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "ProjectDetailsResponse{" +
                "lastModifiedDate='" + lastModifiedDate + '\'' +
                ", revisions=" + revisions +
                ", propertyName='" + propertyName + '\'' +
                ", layout=" + layout +
                ", projectStatus=" + projectStatus +
                ", projectName='" + projectName + '\'' +
                ", projectNumber=" + projectNumber +
                ", originId='" + originId + '\'' +
                '}';
    }
}
