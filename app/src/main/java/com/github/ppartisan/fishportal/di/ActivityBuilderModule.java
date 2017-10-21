package com.github.ppartisan.fishportal.di;

import com.github.ppartisan.fishportal.search.SearchActivity;
import com.github.ppartisan.fishportal.search.SearchActivityModule;
import com.github.ppartisan.fishportal.search.SearchFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = {
            SearchActivityModule.class,
            SearchFragmentProvider.class
    }) abstract SearchActivity bindSearchActivity();
}
