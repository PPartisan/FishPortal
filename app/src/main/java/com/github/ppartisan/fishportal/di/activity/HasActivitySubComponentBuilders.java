package com.github.ppartisan.fishportal.di.activity;

import android.support.v4.app.FragmentActivity;

public interface HasActivitySubComponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends FragmentActivity> aClass);
}
