package com.mentormate.tcos.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse<T> extends BasicPostResponse {

    @SerializedName("Result")
    T result;

    public BaseResponse(List<String> errors, Boolean isSuccess, T result) {
        super(errors, isSuccess);
        this.result = result;
    }
}
