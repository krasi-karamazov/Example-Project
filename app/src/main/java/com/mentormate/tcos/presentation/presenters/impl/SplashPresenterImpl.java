package com.mentormate.tcos.presentation.presenters.impl;

import android.support.annotation.NonNull;

import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.SplashScreenInteractor;
import com.mentormate.tcos.domain.interactors.impl.SplashScreenInteractorImpl;
import com.mentormate.tcos.network.model.DiscoveryResponseModel;
import com.mentormate.tcos.presentation.presenters.SplashPresenter;
import com.mentormate.tcos.presentation.presenters.base.AbstractPresenter;
import com.mentormate.tcos.threading.base.MainThread;

public class SplashPresenterImpl extends AbstractPresenter implements SplashPresenter, SplashScreenInteractor.Callback {

    private Executor mExecutor;
    private MainThread mMainThread;
    private SplashPresenter.View mView;
    private SplashScreenInteractorImpl mSplashScreenInteractor;

    public SplashPresenterImpl(Executor executor, MainThread mainThread, SplashPresenter.View view) {
        super(executor, mainThread);
        this.mExecutor = executor;
        this.mMainThread = mainThread;
        this.mView = view;
    }

    @Override
    public void resume() {
        if (mView.getOneSpotPreferences().isEndPointInformationObtained()) {
            mView.gotToLoginScreen();
        } else {
            //Start the operation immediately
            mSplashScreenInteractor = new SplashScreenInteractorImpl(mExecutor, mMainThread, SplashPresenterImpl.this);
            mExecutor.execute(mSplashScreenInteractor);
        }
    }

    @Override
    public void pause() {

    }


    @Override
    public void stop() {
        cancelInteractor();
    }

    @Override
    public void destroy() {
        cancelInteractor();
    }

    @Override
    public void onError(@NonNull final String message) {
        mView.displayError(message);
    }

    @Override
    public void onSuccess(DiscoveryResponseModel model) {
        //save the obtained endpoints
        mView.getOneSpotPreferences().setAuthorizationEndpoint(model.getAuthorizationEndpoint());
        mView.getOneSpotPreferences().setCheckSessionEndpoint(model.getCheckSessionEndpoint());
        mView.getOneSpotPreferences().setEndSessionEndpoint(model.getEndSessionEndpoint());
        mView.getOneSpotPreferences().setRevocationEndpoint(model.getRevocationEndpoint());
        mView.getOneSpotPreferences().setTokenEndpoint(model.getTokenEndpoint());
        mView.getOneSpotPreferences().setUserInfoEndpoint(model.getUserinfoEndpoint());
        //launch the Login Screenl
        mView.gotToLoginScreen();
    }

    @Override
    public void onError() {
        mView.displayError(R.string.server_error);
    }

    private void cancelInteractor() {
        if (mSplashScreenInteractor != null && mSplashScreenInteractor.isRunning()) {
            mSplashScreenInteractor.cancel();
        }
    }
}
