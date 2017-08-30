package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WorkInfoResponse {
    @SerializedName("DetailedJob")
    @Expose
    public DetailedJob detailedJob;
    @SerializedName("WorkId")
    @Expose
    public String workId;
    @SerializedName("PoiWorks")
    @Expose
    public List<PoiWork> poiWorks = new ArrayList<>();
    @SerializedName("Status")
    @Expose
    public String status;

    public DetailedJob getDetailedJob() {
        return detailedJob;
    }

    public void setDetailedJob(DetailedJob detailedJob) {
        this.detailedJob = detailedJob;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public List<PoiWork> getPoiWorks() {
        return poiWorks;
    }

    public void setPoiWorks(List<PoiWork> poiWorks) {
        this.poiWorks = poiWorks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkInfoResponse{" +
                "detailedJob=" + detailedJob +
                ", workId='" + workId + '\'' +
                ", poiWorks=" + poiWorks +
                ", status='" + status + '\'' +
                '}';
    }
}
