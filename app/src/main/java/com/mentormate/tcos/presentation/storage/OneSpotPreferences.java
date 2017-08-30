package com.mentormate.tcos.presentation.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.mentormate.tcos.network.services.DiscoveryService;

public class OneSpotPreferences {

    private static final String PREFS_NAME = "ONESPOT_PREFS";

    //keys for the endpoints
    private static final String PREFS_KEY_AUTHORIZATION_ENDPOINT = "authorization_endpoint";
    private static final String PREFS_KEY_TOKEN_ENDPOINT = "token_endpoint";
    private static final String PREFS_KEY_USER_INFO_ENDPOINT = "user_info_endpoint";
    private static final String PREFS_KEY_END_SESSION_ENDPOINT = "end_session_endpoint";
    private static final String PREFS_KEY_CHECK_SESSION_ENDPOINT = "check_session_endpoint";
    private static final String PREFS_KEY_REVOCATION_ENDPOINT = "revocation_endpoint";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private static OneSpotPreferences sInstance;

    public static synchronized OneSpotPreferences getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new OneSpotPreferences(context);
        }
        return sInstance;
    }

    public OneSpotPreferences(Context context) {
        this.mPreferences = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    // FIXME: 4/15/2016  Add comments pointing out on which services are the endpoints used
    public void setAuthorizationEndpoint(@NonNull final String authorizationEndpoint) {
        mEditor.putString(PREFS_KEY_AUTHORIZATION_ENDPOINT, authorizationEndpoint)
                .apply();
    }

    @NonNull
    public String getAuthorizationEndpoint() {
        return mPreferences.getString(PREFS_KEY_AUTHORIZATION_ENDPOINT, "");
    }

    public void setTokenEndpoint(@NonNull final String tokenEndpoint) {
        mEditor.putString(PREFS_KEY_TOKEN_ENDPOINT, tokenEndpoint)
                .apply();
    }

    @NonNull
    public String getTokenEndpoint() {
        return mPreferences.getString(PREFS_KEY_TOKEN_ENDPOINT, "");
    }

    public void setUserInfoEndpoint(@NonNull final String userInfoEndpoint) {
        mEditor.putString(PREFS_KEY_USER_INFO_ENDPOINT, userInfoEndpoint)
                .apply();
    }

    @NonNull
    public String getUserInfoEndpoint() {
        return mPreferences.getString(PREFS_KEY_USER_INFO_ENDPOINT, "");
    }

    public void setEndSessionEndpoint(@NonNull final String endSessionEndpoint) {
        mEditor.putString(PREFS_KEY_END_SESSION_ENDPOINT, endSessionEndpoint)
                .apply();
    }

    @NonNull
    public String getEndSessionEndpoint() {
        return mPreferences.getString(PREFS_KEY_END_SESSION_ENDPOINT, "");
    }

    public void setCheckSessionEndpoint(@NonNull final String checkSessionEndpoint) {
        mEditor.putString(PREFS_KEY_CHECK_SESSION_ENDPOINT, checkSessionEndpoint)
                .apply();
    }

    @NonNull
    public String getCheckSessionEndpoint() {
        return mPreferences.getString(PREFS_KEY_CHECK_SESSION_ENDPOINT, "");
    }

    public void setRevocationEndpoint(@NonNull final String revocationEndpoint) {
        mEditor.putString(PREFS_KEY_REVOCATION_ENDPOINT, revocationEndpoint)
                .apply();
    }

    @NonNull
    public String getRevocationEndpoint() {
        return mPreferences.getString(PREFS_KEY_REVOCATION_ENDPOINT, "");
    }

    /**
     * Removes all saved information, which has been obtained from {@link com.mentormate.tcos.network.services.DiscoveryService}.
     */
    public void clearEndpointPreferences() {
        mEditor.remove(PREFS_KEY_AUTHORIZATION_ENDPOINT)
                .remove(PREFS_KEY_CHECK_SESSION_ENDPOINT)
                .remove(PREFS_KEY_END_SESSION_ENDPOINT)
                .remove(PREFS_KEY_REVOCATION_ENDPOINT)
                .remove(PREFS_KEY_TOKEN_ENDPOINT)
                .remove(PREFS_KEY_USER_INFO_ENDPOINT)
                .apply();
    }

    /**
     * Checks if Endpoint information is available.
     *
     * @return whether a call to {@link DiscoveryService#discoverEndpoints()} has been already made
     * and all the information from it is available in the preferences.
     */
    public boolean isEndPointInformationObtained() {
        return mPreferences.contains(PREFS_KEY_AUTHORIZATION_ENDPOINT)
                && mPreferences.contains(PREFS_KEY_CHECK_SESSION_ENDPOINT)
                && mPreferences.contains(PREFS_KEY_END_SESSION_ENDPOINT)
                && mPreferences.contains(PREFS_KEY_REVOCATION_ENDPOINT)
                && mPreferences.contains(PREFS_KEY_TOKEN_ENDPOINT)
                && mPreferences.contains(PREFS_KEY_USER_INFO_ENDPOINT);
    }

}
