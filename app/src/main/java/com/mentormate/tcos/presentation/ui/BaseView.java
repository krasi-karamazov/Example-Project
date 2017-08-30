package com.mentormate.tcos.presentation.ui;


/**
 * An interface which can be implemented by activities or fragments. If the developer chooses he can have a single activity which handles navigation. In this case the fragments are going to implement BaseView
 */

public interface BaseView {

    /**
     * Display a progress dialog, progress spinner in the toolbar
     */
    void showProgress();

    /**
     * Hide the progress displayed previously with the showProgress method
     */
    void hideProgress();

    /**
     * Display an error message on the UI thread
     * @param errorMessage The error message to display
     */
    void displayError(String errorMessage);
}
