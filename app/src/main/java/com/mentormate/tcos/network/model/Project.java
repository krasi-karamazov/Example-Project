package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Project {
    @SerializedName("ProjectId")
    @Expose
    public String projectId;
    @SerializedName("Number")
    @Expose
    public int number;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Category")
    @Expose
    public ProjectCategory category;
    @SerializedName("RevisionNumber")
    @Expose
    public int revisionNumber;
    @SerializedName("LastModifiedDate")
    @Expose
    public String lastModifiedDate;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectCategory getCategory() {
        return category;
    }

    public void setCategory(ProjectCategory category) {
        this.category = category;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", revisionNumber=" + revisionNumber +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                '}';
    }
}
