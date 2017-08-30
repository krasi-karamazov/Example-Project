package com.mentormate.tcos.presentation.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.impl.ThreadExecutor;
import com.mentormate.tcos.presentation.presenters.MainPresenter;
import com.mentormate.tcos.presentation.presenters.base.BasePresenter;
import com.mentormate.tcos.presentation.presenters.impl.MainPresenterImpl;
import com.mentormate.tcos.presentation.ui.activities.base.BaseDrawerActivity;
import com.mentormate.tcos.threading.impl.MainThreadImpl;

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

    @Override
    public void displayMessage(String msg) {
        Log.d("MainActivity", "Success " + msg);
    }
}
