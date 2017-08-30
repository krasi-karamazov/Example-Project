package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContractorJobsResponse {

    @SerializedName("Jobs")
    @Expose
    public List<DetailedJob> detailedJobs = new ArrayList<>();

    public List<DetailedJob> getDetailedJobs() {
        return detailedJobs;
    }

    public void setDetailedJobs(List<DetailedJob> detailedJobs) {
        this.detailedJobs = detailedJobs;
    }

    @Override
    public String toString() {
        return "ContractorJobsResponse{" +
                "detailedJobs=" + detailedJobs +
                '}';
    }
}
