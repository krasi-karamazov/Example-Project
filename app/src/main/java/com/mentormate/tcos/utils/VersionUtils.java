package com.mentormate.tcos.utils;

import android.os.Build;

public class VersionUtils {

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }
}
