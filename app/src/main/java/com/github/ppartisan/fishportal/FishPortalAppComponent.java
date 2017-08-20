package com.github.ppartisan.fishportal;

import com.github.ppartisan.fishportal.di.activity.ActivityBindingModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        FishPortalAppModule.class
})
public interface FishPortalAppComponent {
    void inject(FishPortalApp app);
}
