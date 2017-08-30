package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DetailedBidRequest extends BaseBidRequestModel {
    @SerializedName("BidRequestId")
    @Expose
    public String bidRequestId;
    @SerializedName("Property")
    @Expose
    public Property property;
    @SerializedName("PropertyManagerOrgId")
    @Expose
    public String propertyManagerOrgId;

    @SerializedName("Description")
    @Expose
    public String description;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("StartedAt")
    @Expose
    public String startedAt;

    @SerializedName("ContractorIds")
    @Expose
    public List<String> contractorIds = new ArrayList();


    public String getBidRequestId() {
        return bidRequestId;
    }

    public void setBidRequestId(String bidRequestId) {
        this.bidRequestId = bidRequestId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getPropertyManagerOrgId() {
        return propertyManagerOrgId;
    }

    public void setPropertyManagerOrgId(String propertyManagerOrgId) {
        this.propertyManagerOrgId = propertyManagerOrgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public List<String> getContractorIds() {
        return contractorIds;
    }

    public void setContractorIds(List<String> contractorIds) {
        this.contractorIds = contractorIds;
    }

    @Override
    public String toString() {
        return "DetailedBidRequest{" +
                "bidRequestId='" + bidRequestId + '\'' +
                ", property=" + property +
                ", propertyManagerOrgId='" + propertyManagerOrgId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startedAt='" + startedAt + '\'' +
                ", assessments=" + assessments +
                ", contractorIds=" + contractorIds +
                '}';
    }
}
