package com.github.ppartisan.fishportal.di.activity;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ActivityModule<T> {

    protected final T activity;

    public ActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope public T activity() {
        return activity;
    }

}
