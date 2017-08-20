package com.github.ppartisan.fishportal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.github.ppartisan.fishportal.di.activity.ActivityComponentBuilder;
import com.github.ppartisan.fishportal.di.activity.HasActivitySubComponentBuilders;

import java.util.Map;

import javax.inject.Inject;

public class FishPortalApp extends Application implements HasActivitySubComponentBuilders {

    @Inject Map<Class<? extends Activity>, ActivityComponentBuilder> activityComponentBuilders;

    private FishPortalAppComponent component;

    public static HasActivitySubComponentBuilders get(Context context) {
        return ((HasActivitySubComponentBuilders) context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerFishPortalAppComponent.builder()
                .fishPortalAppModule(new FishPortalAppModule(this))
                .build();
        component.inject(this);
    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends FragmentActivity> aClass) {
        return activityComponentBuilders.get(aClass);
    }
}
