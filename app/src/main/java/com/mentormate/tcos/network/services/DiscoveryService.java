package com.mentormate.tcos.network.services;

import com.mentormate.tcos.network.model.DiscoveryResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DiscoveryService {
    //HOST to be used in conjunction with this service
    String HOST = "host_url";

    @GET("/.well-known/openid-configuration")
    Call<DiscoveryResponseModel> discoverEndpoints();

}
