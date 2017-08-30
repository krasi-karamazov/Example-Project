package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointDetailsResponse {
    @SerializedName("Project")
    @Expose
    public Project project;
    @SerializedName("Layout")
    @Expose
    public PoiLayout layout;
    @SerializedName("Property")
    @Expose
    public SimpleProperty property;
    @SerializedName("DetailedJob")
    @Expose
    public RevisionJob job;
    @SerializedName("BidRequest")
    @Expose
    public PointBidRequest bidRequest;
    @SerializedName("Coordinates")
    @Expose
    public Coordinates coordinates;
}
