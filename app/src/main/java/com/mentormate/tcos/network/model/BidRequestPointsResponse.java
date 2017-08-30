package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BidRequestPointsResponse {
    @SerializedName("ProjectBidRequestId")
    @Expose
    public String projectBidRequestId;
    @SerializedName("ContractorBidRequest")
    @Expose
    public String contractorBidRequest;
    @SerializedName("PoiList")
    @Expose
    public List<PoiList> poiList = new ArrayList<>();


    public String getProjectBidRequestId() {
        return projectBidRequestId;
    }

    public void setProjectBidRequestId(String projectBidRequestId) {
        this.projectBidRequestId = projectBidRequestId;
    }

    public String getContractorBidRequest() {
        return contractorBidRequest;
    }

    public void setContractorBidRequest(String contractorBidRequest) {
        this.contractorBidRequest = contractorBidRequest;
    }

    public List<PoiList> getPoiList() {
        return poiList;
    }

    public void setPoiList(List<PoiList> poiList) {
        this.poiList = poiList;
    }

    @Override
    public String toString() {
        return "BidRequestPointsResponse{" +
                "projectBidRequestId='" + projectBidRequestId + '\'' +
                ", contractorBidRequest='" + contractorBidRequest + '\'' +
                ", poiList=" + poiList +
                '}';
    }
}
