package com.mentormate.tcos.presentation.ui.activities.impl;

import android.os.Bundle;
import android.util.Log;
import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.impl.ThreadExecutor;
import com.mentormate.tcos.presentation.navigation.events.NavigationEvent;
import com.mentormate.tcos.presentation.presenters.MainPresenter;
import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.presenters.impl.MainPresenterImpl;
import com.mentormate.tcos.presentation.ui.activities.base.BaseDrawerActivity;
import com.mentormate.tcos.threading.impl.MainThreadImpl;
import com.mentormate.tcos.utils.Logger;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseDrawerActivity implements MainPresenter.View {

    private BasePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void displayMessage(String msg) {
        Log.d("MainActivity", "Success " + msg);
    }

    @Override
    public void setHomeAsUpEnabled(boolean homeAsUpEnabled) {

    }

    @Override
    protected int getMenuResourceId() {
        return R.menu.menu_main;
    }

    @Override
    protected boolean handleMenuClick(int menuItemId) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Subscribe
    public void onNavigationEvent(NavigationEvent event) {
        Logger.d("Navigation called on MainActivity");
        consumeNavigationEvent(event);
    }
}
