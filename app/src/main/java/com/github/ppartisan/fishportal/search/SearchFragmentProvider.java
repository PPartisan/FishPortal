package com.github.ppartisan.fishportal.search;

import com.github.ppartisan.fishportal.search.fragment.SearchFragment;
import com.github.ppartisan.fishportal.search.fragment.SearchFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SearchFragmentProvider {
    @ContributesAndroidInjector(modules = SearchFragmentModule.class) abstract SearchFragment searchFragment();
}
