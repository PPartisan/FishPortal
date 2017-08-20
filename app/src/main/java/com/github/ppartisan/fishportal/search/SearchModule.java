package com.github.ppartisan.fishportal.search;

import android.arch.lifecycle.ViewModelProviders;

import com.github.ppartisan.fishportal.di.activity.ActivityModule;
import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule extends ActivityModule<SearchActivity>{

    SearchModule(SearchActivity searchActivity) {
        super(searchActivity);
    }

    @Provides
    SearchItemViewModel searchItemViewModel() {
        return ViewModelProviders.of(activity).get(SearchItemViewModel.class);
    }

}
