package com.mentormate.tcos.presentation.presenters;

import android.support.annotation.StringRes;

import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.storage.OneSpotPreferences;
import com.mentormate.tcos.presentation.ui.BaseView;


public interface SplashPresenter extends BasePresenter {

    interface View extends BaseView {

        void gotToLoginScreen();

        OneSpotPreferences getOneSpotPreferences();

        void displayError(@StringRes final int errorMsg);

    }

}
