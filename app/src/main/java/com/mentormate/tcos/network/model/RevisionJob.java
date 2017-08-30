package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RevisionJob extends BaseJobModel {
    @SerializedName("StartDate")
    @Expose
    public String startDate;
    @SerializedName("EndDate")
    @Expose
    public String endDate;
    @SerializedName("ContractorId")
    @Expose
    public String contractorId;

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

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    @Override
    public String toString() {
        return "RevisionJob{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", contractorId='" + contractorId + '\'' +
                '}';
    }
}
