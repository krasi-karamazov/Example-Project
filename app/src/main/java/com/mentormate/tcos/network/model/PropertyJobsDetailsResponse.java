package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PropertyJobsDetailsResponse {
    @SerializedName("Properties")
    @Expose
    public List<Property> properties = new ArrayList();
    @SerializedName("Layouts")
    @Expose
    public List<PoiLayout> layouts = new ArrayList<>();
    @SerializedName("Jobs")
    @Expose
    public List<ProjectJob> jobs = new ArrayList<>();

}
