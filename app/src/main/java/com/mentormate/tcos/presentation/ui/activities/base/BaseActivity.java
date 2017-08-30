package com.mentormate.tcos.presentation.ui.activities.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mentormate.tcos.R;
import com.mentormate.tcos.presentation.navigation.events.NavigationEvent;
import com.mentormate.tcos.presentation.ui.BaseView;
import com.mentormate.tcos.presentation.ui.fragments.dialogs.BaseDialog;
import com.mentormate.tcos.presentation.ui.fragments.dialogs.BasicMessageDialog;
import com.mentormate.tcos.presentation.ui.fragments.dialogs.ProgressDialog;
import com.mentormate.tcos.utils.BusProvider;
import com.mentormate.tcos.utils.Logger;

import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        Logger.d("NullState");
        BusProvider.getInstance().unregister(this);
        ButterKnife.unbind(BaseActivity.this);
        super.onDestroy();
    }

    public final SharedPreferences getSharedPreferences() {
        if (mPrefs == null) {
            // TODO: 4/19/2016 Should we use OneSpotPreferences instead ?
            mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        }
        return mPrefs;
    }


    @Subscribe
    public void onNavigationEvent(NavigationEvent event) {
        Logger.d("Navigation called on MainActivity");
        consumeNavigationEvent(event);
    }

    protected final void consumeNavigationEvent(NavigationEvent event) {
        Logger.d("Navigation called on BaseDrawerActivity");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (event.getShouldAnimateTransaction()) {
            transaction.setCustomAnimations(R.anim.left_in, R.anim.left_out, R.anim.left_in, R.anim.left_out);
        }

        if (event.getShouldPopBackStack()) {
            try {
                popBackStack();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (event.shouldChangeDrawerToBackArrow()) {
            if (hasDrawer()) {
                ((BaseDrawerActivity) this).changeDrawerIndicator(true);
            }
        }
        int containerId;
        if (event.getContainerId() != 0) {
            containerId = event.getContainerId();
            transaction.addToBackStack(event.getFragment().getBackstackTag());
        } else {
            containerId = R.id.fl_fragment_container;
            transaction.addToBackStack(event.getFragment().getBackstackTag());
        }

        transaction.replace(containerId, event.getFragment(), event.getFragment().getBackstackTag());
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
    }

    public final void popBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStackImmediate();
        }
    }

    @Override
    public void onBackPressed() {
        if (hasDrawer()) {
            handleDrawerSpecificLogic();
        } else {
            navigateBackwards();
        }
    }

    protected void navigateBackwards() {
        int backStackCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackCount <= 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(getMenuResourceId(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return handleMenuClick(id);
    }

    @Override
    public void showProgress() {
        try {
            FragmentManager fm = getSupportFragmentManager();
            if (fm.findFragmentByTag(ProgressDialog.TAG) == null) {
                Bundle args = new Bundle();
                args.putString(BaseDialog.MESSAGE_ARG_KEY, getString(R.string.please_wait));
                BaseDialog progressDialog = ProgressDialog.getInstance(args);
                progressDialog.show(getSupportFragmentManager(), ProgressDialog.TAG);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void hideProgress() {
        try {
            BaseDialog dialog = (ProgressDialog) getSupportFragmentManager().findFragmentByTag(ProgressDialog.TAG);
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void displayError(String errorMessage) {
        BasicMessageDialog.getInstance(null, null).show(getSupportFragmentManager(), BasicMessageDialog.TAG);
    }

    protected abstract boolean hasDrawer();
    protected abstract void handleDrawerSpecificLogic();
    protected abstract int getMenuResourceId();
    protected abstract boolean handleMenuClick(int menuItemId);

    protected abstract int getLayoutId();
}
