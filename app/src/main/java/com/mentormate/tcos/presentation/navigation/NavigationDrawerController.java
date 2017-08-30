package com.mentormate.tcos.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.mentormate.tcos.R;
import com.mentormate.tcos.presentation.navigation.adapter.NavigationAdapter;
import com.mentormate.tcos.presentation.navigation.models.SlidingMenuItemModel;
import com.mentormate.tcos.presentation.navigation.models.SlidingMenuModel;
import com.mentormate.tcos.presentation.presenters.base.BaseDrawerPresenter;

public class NavigationDrawerController implements NavigationItemClickListener {
    private static NavigationDrawerController sInstance;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView mDrawerListView;
    private SlidingMenuModel mModel;
    private NavigationAdapter listAdapter;
    private Context mContext;
    private SharedPreferences prefs;
    private boolean locked;
    private int selectedIndex = 0;
    private View headerView;
    private BaseDrawerPresenter.BaseDrawerView baseDrawerView;

    public static synchronized NavigationDrawerController getInstance() {
        if (sInstance == null) {
            sInstance = new NavigationDrawerController();
        }

        return sInstance;
    }

    private NavigationDrawerController() {

    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return mDrawerToggle;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }

    public void init(BaseDrawerPresenter.BaseDrawerView baseDrawerView) {
        mContext = baseDrawerView.getContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(mContext.getApplicationContext());
        mModel = SlidingMenuModel.getInstance(mContext);

        ViewGroup view = (ViewGroup) ((AppCompatActivity) mContext).getWindow().getDecorView();
        View content = view.getChildAt(0);
        mDrawerListView = (RecyclerView) content.findViewById(R.id.menu_list);
        mDrawerListView.setLayoutManager(new LinearLayoutManager(mContext));
        listAdapter = new NavigationAdapter(mModel.getData(), this, prefs, mContext);

        mDrawerLayout = (DrawerLayout) content.findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerToggle = getDrawerListener(mContext);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerListView.setAdapter(listAdapter);
        selectedIndex = 0;
    }

    private AdapterView.OnItemClickListener getOnItemClickLIstener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //onNavigationEvent(position - mDrawerListView.getHeaderViewsCount());
            }
        };
    }

    public void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    @Override
    public void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void updateDrawer() {
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public boolean isDrawerOpened() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    private ActionBarDrawerToggle getDrawerListener(Context context) {
        return new ActionBarDrawerToggle((AppCompatActivity) context, mDrawerLayout, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
    }

    private void generateIntentAndStartActivity(Class activityClass, Bundle args) {
        Intent intent = new Intent(mContext, activityClass);
        if (args != null && args.size() > 0) {
            intent.putExtras(args);
        }
        mContext.startActivity(intent);
    }

    public void toggleLockDrawer(boolean shouldLock) {
        if (shouldLock) {
            mDrawerLayout.getDrawerLockMode(GravityCompat.START);
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            locked = true;
        } else {
            mDrawerLayout.getDrawerLockMode(GravityCompat.START);
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            locked = false;
        }
    }

    public void setDrawerState(boolean isEnabled) {
        if (isEnabled) {
            baseDrawerView.setHomeAsUpEnabled(true);
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerToggle.syncState();

        } else {
            baseDrawerView.setHomeAsUpEnabled(false);
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            mDrawerToggle.syncState();
        }
    }

    public void closeDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void openDrawer() {
        if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public void onNavigationEvent(int index) {
        if (selectedIndex == index) {
            return;
        }
        selectedIndex = index;
        Bundle args = new Bundle();
        SlidingMenuItemModel model = mModel.getItem(index);

        /*switch (whichView) {



        }*/
        setSelectedIndex(selectedIndex - 1);
        listAdapter.notifyDataSetChanged();
        toggleDrawer();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void invalidateSelectedIndex() {
        selectedIndex = -1;
    }
}
