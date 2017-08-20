package com.github.ppartisan.fishportal.di.activity;

import com.github.ppartisan.fishportal.search.SearchActivity;
import com.github.ppartisan.fishportal.search.SearchComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = SearchComponent.class)
public abstract class ActivityBindingModule {
    @Binds @IntoMap @ActivityKey(SearchActivity.class) public abstract ActivityComponentBuilder searchActivityComponentBuilder(SearchComponent.Builder builder);
}
