package com.mentormate.tcos.presentation.ui.activities.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mentormate.tcos.R;
import com.mentormate.tcos.domain.executor.impl.ThreadExecutor;
import com.mentormate.tcos.presentation.presenters.SplashPresenter;
import com.mentormate.tcos.presentation.presenters.impl.SplashPresenterImpl;
import com.mentormate.tcos.presentation.storage.OneSpotPreferences;
import com.mentormate.tcos.presentation.ui.activities.base.BaseActivity;
import com.mentormate.tcos.threading.impl.MainThreadImpl;
import com.mentormate.tcos.utils.VersionUtils;

import butterknife.Bind;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends BaseActivity implements SplashPresenter.View {


    @Bind(R.id.fl_content)
    ViewGroup mContentVg;

    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFullscreenFlags();
        mSplashPresenter = new SplashPresenterImpl(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(), SplashActivity.this);
    }

    private void setFullscreenFlags() {
        int flags = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

        if (VersionUtils.hasJellyBean()) {
            flags = flags | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }

        mContentVg.setSystemUiVisibility(flags);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSplashPresenter.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSplashPresenter.destroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSplashPresenter.stop();
    }

    @Override
    public void gotToLoginScreen() {
        final Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void displayError(@NonNull String errorMsg) {
        showToast(errorMsg);
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
        return 0;
    }

    @Override
    protected boolean handleMenuClick(int menuItemId) {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public OneSpotPreferences getOneSpotPreferences() {
        return OneSpotPreferences.getInstance(SplashActivity.this);
    }

    @Override
    public void displayError(@StringRes int errorMsg) {
        showToast(getString(errorMsg));
    }

    private void showToast(@NonNull final String msg) {
        Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
