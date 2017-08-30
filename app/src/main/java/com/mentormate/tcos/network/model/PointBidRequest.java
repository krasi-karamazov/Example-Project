package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointBidRequest extends BaseBidRequestModel {

    @SerializedName("AssesmentRequestId")
    @Expose
    public String assesmentRequestId;
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
        return "PointBidRequest{" +
                "assesmentRequestId='" + assesmentRequestId + '\'' +
                ", name='" + name + '\'' +
                ", assessments=" + assessments +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
