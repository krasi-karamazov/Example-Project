package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class AssessmentRequest {
    @SerializedName("AssesmentRequestId")
    @Expose
    public String assesmentRequestId;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Assessments")
    @Expose
    public List<Assessment> assessments = new ArrayList<>();
    @SerializedName("StartDate")
    @Expose
    public String startDate;
    @SerializedName("EndDate")
    @Expose
    public String endDate;
    @SerializedName("Status")
    @Expose
    public String status;

    public String getAssesmentRequestId() {
        return assesmentRequestId;
    }

    public void setAssesmentRequestId(String assesmentRequestId) {
        this.assesmentRequestId = assesmentRequestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssessmentRequest{" +
                "assesmentRequestId='" + assesmentRequestId + '\'' +
                ", name='" + name + '\'' +
                ", assessments=" + assessments +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
