package com.github.ppartisan.fishportal;

import android.content.Context;
import android.view.LayoutInflater;

import com.github.ppartisan.fishportal.model.ModelModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton @Module(includes = ModelModule.class)
class FishPortalAppModule {

    private final Context context;

    FishPortalAppModule(Context context) {
        this.context = context;
    }

    @Provides @Singleton Context context() {
        return context;
    }

    @Provides @Singleton LayoutInflater layoutInflater() {
        return LayoutInflater.from(context);
    }

}
