package com.mentormate.tcos.presentation.presenters;

import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.ui.BaseView;

public interface LoginPresenter extends BasePresenter {
    interface View extends BaseView {
        void onLoginButtonClicked();
    }
    void startLoginProcess();
}
