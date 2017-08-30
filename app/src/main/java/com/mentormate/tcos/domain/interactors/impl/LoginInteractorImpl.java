package com.mentormate.tcos.domain.interactors.impl;

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.LoginInteractor;
import com.mentormate.tcos.domain.interactors.base.AbstractInteractor;
import com.mentormate.tcos.domain.model.impl.LoginModel;
import com.mentormate.tcos.domain.repository.impl.LoginRepository;
import com.mentormate.tcos.network.RestClient;
import com.mentormate.tcos.network.services.TCOSLoginInterface;
import com.mentormate.tcos.threading.base.MainThread;

import java.io.IOException;

import retrofit2.Call;

public class LoginInteractorImpl extends AbstractInteractor<LoginModel> implements LoginInteractor {
    private static final String CLIENT_ID = "introclient";
    private static final String SECRET_ID = "intsecret";

    private LoginInteractor.CallBack mCallBack;
    private LoginRepository mRepository;
    private long mSessionID;

    public LoginInteractorImpl(Executor threadExecutor, MainThread mainThread,
        LoginInteractor.CallBack callBack, LoginRepository repository, long sessionId) {
        super(threadExecutor, mainThread);
        mCallBack = callBack;
        mRepository = repository;
        mSessionID = sessionId;
    }

    @Override
    public void run() {
        Call<LoginModel> call = RestClient.getService(TCOSLoginInterface.class)
            .getToken(null, null, null, null, null, null);
        LoginModel model = null;
        try {
            model = call.execute()
                .body();
        } catch (IOException e) {
            notifyError();
            return;
        }
        if(model == null) {
            notifyError();
        }else{
            postResult(model);
        }

    }

    @Override
    protected void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallBack.onLoginError("No results found!");
            }
        });
    }

    @Override
    protected void postResult(final LoginModel result) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallBack.onLoginSuccess(result);
            }
        });
    }
}