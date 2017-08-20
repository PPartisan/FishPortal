package com.github.ppartisan.fishportal.util;

import android.content.res.Resources;

public final class ViewUtils {

    private static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    public static int dpToPx(int dp) {
        return (int) (dp * DENSITY);
    }

    public static int pxToDp(int px) {
        return (int) (px / DENSITY);
    }

}
