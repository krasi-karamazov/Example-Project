package com.mentormate.tcos.presentation.presenters.impl;

import com.mentormate.tcos.domain.executor.base.Executor;
import com.mentormate.tcos.domain.interactors.LoginInteractor;
import com.mentormate.tcos.domain.interactors.impl.LoginInteractorImpl;
import com.mentormate.tcos.domain.model.impl.LoginModel;
import com.mentormate.tcos.domain.repository.impl.LoginRepository;
import com.mentormate.tcos.presentation.presenters.LoginPresenter;
import com.mentormate.tcos.presentation.presenters.base.AbstractPresenter;
import com.mentormate.tcos.threading.base.MainThread;

public class LoginPresenterImpl extends AbstractPresenter implements LoginPresenter,
    LoginInteractor.CallBack {
    private LoginPresenter.View mView;
    private Executor mExecutor;
    private MainThread mMainThread;
    private LoginRepository mLoginRepository;
    private LoginInteractorImpl mLoginInteractor;

    public LoginPresenterImpl(Executor executor, MainThread mainThread, LoginPresenter.View view) {
        super(executor, mainThread);
        mView = view;
        mExecutor = executor;
        mMainThread = mainThread;
        mLoginRepository = new LoginRepository();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        if (mLoginInteractor.isRunning()) {
            mLoginInteractor.cancel();
        }
    }

    @Override
    public void stop() {
        if (mLoginInteractor.isRunning()) {
            mLoginInteractor.cancel();
        }
    }

    @Override
    public void destroy() {
        if (mLoginInteractor.isRunning()) {
            mLoginInteractor.cancel();
        }
    }

    @Override
    public void onError(String message) {
        mView.hideProgress();
        mView.displayError(message);
    }

    @Override
    public void onLoginSuccess(LoginModel model) {
        mView.hideProgress();
    }

    @Override
    public void onLoginError(String error) {
        mView.hideProgress();
        mView.displayError(error);
    }

    @Override
    public void startLoginProcess() {
        mView.showProgress();
        mLoginInteractor =
            new LoginInteractorImpl(mExecutor, mMainThread, this, mLoginRepository, 0);
        mLoginInteractor.execute();
    }
}