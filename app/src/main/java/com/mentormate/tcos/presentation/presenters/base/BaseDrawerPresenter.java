package com.mentormate.tcos.presentation.presenters.base;

import android.content.Context;

import com.mentormate.tcos.presentation.ui.BaseView;

public interface BaseDrawerPresenter {
    interface BaseDrawerView extends BaseView {
        void setHomeAsUpEnabled(boolean homeAsUpEnabled);
        void changeDrawerIndicator(boolean toggleLock);
        void toggleDrawer(boolean open);
        Context getContext();
    }
}
