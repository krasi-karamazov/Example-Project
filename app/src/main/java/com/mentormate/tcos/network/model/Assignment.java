package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assignment {
    @SerializedName("ContractorId")
    @Expose
    private String contractorId;
    @SerializedName("PropertyManagerOrgId")
    @Expose
    private String propertyManagerOrgId;

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public String getPropertyManagerOrgId() {
        return propertyManagerOrgId;
    }

    public void setPropertyManagerOrgId(String propertyManagerOrgId) {
        this.propertyManagerOrgId = propertyManagerOrgId;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "contractorId='" + contractorId + '\'' +
                ", propertyManagerOrgId='" + propertyManagerOrgId + '\'' +
                '}';
    }
}
