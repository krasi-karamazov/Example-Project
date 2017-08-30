package com.mentormate.tcos.domain.interactors.impl;

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.SplashScreenInteractor;
import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;
import com.mentormate.tcos.network.RestClient;
import com.mentormate.tcos.network.model.DiscoveryResponseModel;
import com.mentormate.tcos.network.services.DiscoveryService;
import com.mentormate.tcos.threading.base.MainThread;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SplashScreenInteractorImpl extends AbstractInteractor<DiscoveryResponseModel>
        implements SplashScreenInteractor {

    private SplashScreenInteractor.Callback mCallBack;
    private Response<DiscoveryResponseModel> mResponse;

    public SplashScreenInteractorImpl(Executor threadExecutor,
                                      MainThread mainThread,
                                      SplashScreenInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        this.mCallBack = callback;
    }

    @Override
    public void run() {
        //set the host to the one used by the service
        RestClient.setHost(DiscoveryService.HOST);
        //create the service
        Call<DiscoveryResponseModel> discoveryResponseModelCall =
                RestClient.getService(DiscoveryService.class).discoverEndpoints();

        try {
            mResponse = discoveryResponseModelCall.execute();

            if (mResponse.isSuccessful()) {
                postResult(mResponse.body());
            } else {
                notifyError();
            }

        } catch (IOException e) {
            e.printStackTrace();
            notifyError();
        }
    }

    @Override
    protected void notifyError() {
        //reset HOST to the base one
        RestClient.setHost(null);
        //notify, that an error has occurred 
        mCallBack.onError();
    }

    @Override
    protected void postResult(DiscoveryResponseModel result) {
        //reset HOST to the base one
        RestClient.setHost(null);
        //post the result
        mCallBack.onSuccess(result);
    }
}
