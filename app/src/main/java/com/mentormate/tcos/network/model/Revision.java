package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Revision {

    @SerializedName("ProjectId")
    @Expose
    public String projectId;
    @SerializedName("AssessmentRequests")
    @Expose
    public List<AssessmentRequest> assessmentRequests = new ArrayList<>();
    @SerializedName("DetailedJob")
    @Expose
    public RevisionJob job;
    @SerializedName("StartDate")
    @Expose
    public String startDate;
    @SerializedName("EndDate")
    @Expose
    public String endDate;
    @SerializedName("IsOrigin")
    @Expose
    public boolean isOrigin;
    @SerializedName("RevisionNumber")
    @Expose
    public int revisionNumber;
    @SerializedName("RevisionStatus")
    @Expose
    public RevisionStatus revisionStatus;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<AssessmentRequest> getAssessmentRequests() {
        return assessmentRequests;
    }

    public void setAssessmentRequests(List<AssessmentRequest> assessmentRequests) {
        this.assessmentRequests = assessmentRequests;
    }

    public RevisionJob getJob() {
        return job;
    }

    public void setJob(RevisionJob job) {
        this.job = job;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isOrigin() {
        return isOrigin;
    }

    public void setOrigin(boolean origin) {
        isOrigin = origin;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public RevisionStatus getRevisionStatus() {
        return revisionStatus;
    }

    public void setRevisionStatus(RevisionStatus revisionStatus) {
        this.revisionStatus = revisionStatus;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "projectId='" + projectId + '\'' +
                ", assessmentRequests=" + assessmentRequests +
                ", detailedJob=" + job +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", isOrigin=" + isOrigin +
                ", revisionNumber=" + revisionNumber +
                ", revisionStatus=" + revisionStatus +
                '}';
    }
}
