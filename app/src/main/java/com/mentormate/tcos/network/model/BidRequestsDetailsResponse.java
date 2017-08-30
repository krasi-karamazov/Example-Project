package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BidRequestsDetailsResponse {
    @SerializedName("BidRequests")
    @Expose
    public List<DetailedBidRequest> detailedBidRequests = new ArrayList<>();
    @SerializedName("PagingOptions")
    @Expose
    public PagingOptions pagingOptions;

    public List<DetailedBidRequest> getDetailedBidRequests() {
        return detailedBidRequests;
    }

    public void setDetailedBidRequests(List<DetailedBidRequest> detailedBidRequests) {
        this.detailedBidRequests = detailedBidRequests;
    }

    public PagingOptions getPagingOptions() {
        return pagingOptions;
    }

    public void setPagingOptions(PagingOptions pagingOptions) {
        this.pagingOptions = pagingOptions;
    }

    @Override
    public String toString() {
        return "BidRequestsDetailsResponse{" +
                "detailedBidRequests=" + detailedBidRequests +
                ", pagingOptions=" + pagingOptions +
                '}';
    }
}
