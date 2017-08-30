package com.mentormate.tcos.presentation.ui.activities.impl;

import android.util.Log;
import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.impl.ThreadExecutor;
import com.mentormate.tcos.presentation.presenters.LoginPresenter;
import com.mentormate.tcos.presentation.presenters.impl.LoginPresenterImpl;
import com.mentormate.tcos.presentation.ui.activities.base.BaseActivity;
import com.mentormate.tcos.threading.impl.MainThreadImpl;


public class LoginActivity extends BaseActivity implements LoginPresenter.View {
    private static final String TAG = "LoginActivity";
    private LoginPresenterImpl mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter = new LoginPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), this);
        mPresenter.resume();
        onLoginButtonClicked();
    }

    @Override
    public void showProgress() {
        Log.d("Login", "Showing progress");
    }

    @Override
    public void hideProgress() {
        Log.d("Login", "Hiding progress");
    }

    @Override
    public void displayError(String errorMessage) {
        Log.d("Login", "Success " + errorMessage);
    }

    @Override
    protected boolean hasDrawer() {
        return false;
    }

    @Override
    protected void handleDrawerSpecificLogic() {

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
    public void onLoginButtonClicked() {
        mPresenter.startLoginProcess();
    }
}
