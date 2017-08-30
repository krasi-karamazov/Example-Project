package com.mentormate.tcos.network.services;

import com.mentormate.tcos.domain.model.impl.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TCOSLoginInterface {

    @FormUrlEncoded
    @POST("/connect/token")
    Call<LoginModel> getToken(@Header("Content-Type") String contentType,
        @Header("Authorization") String authorization, @Field("username") String username,
        @Field("password") String password, @Field("grant_type") String grantType,
        @Field("scope") String scope);

}
