package com.github.ppartisan.fishportal.di.activity;

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent<?>>{
    ActivityComponentBuilder<M, C> activityModule(M ActivityModule);
    C build();
}
