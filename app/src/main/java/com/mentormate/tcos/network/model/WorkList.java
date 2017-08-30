package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WorkList {

    @SerializedName("WorkId")
    @Expose
    private String workId;
    @SerializedName("PoiWork")
    @Expose
    private List<PoiWork> poiWorkArrayList = new ArrayList<>();
    @SerializedName("Status")
    @Expose
    private String status;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public List<PoiWork> getPoiWorkArrayList() {
        return poiWorkArrayList;
    }

    public void setPoiWorkArrayList(List<PoiWork> poiWorkArrayList) {
        this.poiWorkArrayList = poiWorkArrayList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkList{" +
                "workId='" + workId + '\'' +
                ", poiWorkArrayList=" + poiWorkArrayList +
                ", status='" + status + '\'' +
                '}';
    }
}
