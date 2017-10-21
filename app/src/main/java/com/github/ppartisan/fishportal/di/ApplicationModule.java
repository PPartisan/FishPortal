package com.github.ppartisan.fishportal.di;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import com.github.ppartisan.fishportal.model.ModelModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ModelModule.class)
class ApplicationModule {

    @Provides @Singleton Context context(Application application) {
        return application;
    }

    @Provides @Singleton LayoutInflater layoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

}
