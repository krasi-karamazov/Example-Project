package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DetailedJob extends BaseJobModel {

    @SerializedName("Description")
    @Expose
    public String description;

    @SerializedName("Property")
    @Expose
    public Property property;

    @SerializedName("WorkList")
    @Expose
    public List<WorkList> workList = new ArrayList<>();
    @SerializedName("workCount")
    @Expose
    public int workCount;
    @SerializedName("Assignment")
    @Expose
    public Assignment assignment;
    @SerializedName("RequireChangeOrders")
    @Expose
    public boolean requireChangeOrders;


    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WorkList> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkList> workList) {
        this.workList = workList;
    }

    public int getWorkCount() {
        return workCount;
    }

    public void setWorkCount(int workCount) {
        this.workCount = workCount;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public boolean isRequireChangeOrders() {
        return requireChangeOrders;
    }

    public void setRequireChangeOrders(boolean requireChangeOrders) {
        this.requireChangeOrders = requireChangeOrders;
    }

    @Override
    public String toString() {
        return "DetailedJob{" +
                "description='" + description + '\'' +
                ", property=" + property +
                ", workList=" + workList +
                ", workCount=" + workCount +
                ", assignment=" + assignment +
                ", requireChangeOrders=" + requireChangeOrders +
                '}';
    }
}
