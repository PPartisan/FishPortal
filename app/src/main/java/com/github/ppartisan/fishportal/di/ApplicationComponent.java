package com.github.ppartisan.fishportal.di;

import android.app.Application;

import com.github.ppartisan.fishportal.FishPortalApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        ActivityBuilderModule.class,
        AndroidInjectionModule.class,
        ApplicationModule.class
})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        ApplicationComponent build();
    }

    void inject(FishPortalApp app);
}
