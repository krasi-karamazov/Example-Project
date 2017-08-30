package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class BasicPostResponse {

    @SerializedName("Errors")
    @Expose
    private List<String> errors = new ArrayList<>();
    @SerializedName("IsSuccess")
    @Expose
    private Boolean isSuccess;


    public BasicPostResponse(List<String> errors, Boolean isSuccess) {
        this.errors = errors;
        this.isSuccess = isSuccess;
    }

    /**
     * @return The Errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param Errors The Errors
     */
    public void setErrors(List<String> Errors) {
        this.errors = Errors;
    }

    /**
     * @return The IsSuccess
     */
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     * @param IsSuccess The IsSuccess
     */
    public void setIsSuccess(Boolean IsSuccess) {
        this.isSuccess = IsSuccess;
    }

}
