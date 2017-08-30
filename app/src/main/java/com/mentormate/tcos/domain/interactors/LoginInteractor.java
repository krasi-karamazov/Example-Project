package com.mentormate.tcos.domain.interactors;

import com.mentormate.tcos.domain.model.impl.LoginModel;

public interface LoginInteractor {
    interface CallBack {
        void onLoginSuccess(LoginModel model);

        void onLoginError(String error);
    }
}