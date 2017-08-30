package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoiCategory {
    @SerializedName("Industry")
    @Expose
    private String industry;
    @SerializedName("Subject")
    @Expose
    private String subject;
    @SerializedName("Service")
    @Expose
    private String service;
    @SerializedName("Condition")
    @Expose
    private String condition;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "PoiCategory{" +
                "condition='" + condition + '\'' +
                ", service='" + service + '\'' +
                ", subject='" + subject + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
