package com.mentormate.tcos.utils;

import com.mentormate.tcos.R;
import com.mentormate.tcos.presentation.navigation.events.NavigationEvent;
import com.mentormate.tcos.presentation.ui.fragments.BaseFragment;

import org.greenrobot.eventbus.EventBus;

public class BusProvider {
    private static final EventBus BUS = new EventBus();
    private BaseFragment fragment;
    private boolean shouldPopBackstack;
    private boolean shouldAnimateTransition;
    private boolean shouldChangeHomeButtonToBackArrow;

    public static EventBus getInstance(){
        return BUS;
    }

    public static BusProvider getInstanceProvider(){
        return new BusProvider();
    }

    private BusProvider(){}

    public void navigateToFragment(BaseFragment fragment,  boolean shouldPopBackstack, boolean shouldAnimateTransition, boolean shouldChangeHomeButtonToBackArrow) {
        this.fragment = fragment;
        this.shouldPopBackstack = shouldPopBackstack;
        this.shouldAnimateTransition = shouldAnimateTransition;
        this.shouldChangeHomeButtonToBackArrow = shouldChangeHomeButtonToBackArrow;
        BusProvider.getInstance().post(getNavigationEvent());
    }

    public NavigationEvent getNavigationEvent() {
        return new NavigationEvent(fragment, shouldPopBackstack, shouldAnimateTransition, shouldChangeHomeButtonToBackArrow, R.id.fl_fragment_container);
    }
}
