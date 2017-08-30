package com.mentormate.tcos.presentation.presenters;

import android.content.Context;

import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.ui.BaseView;

public interface MainPresenter extends BasePresenter {
    interface View extends BaseView{
        void displayMessage(String msg);
    }
}
