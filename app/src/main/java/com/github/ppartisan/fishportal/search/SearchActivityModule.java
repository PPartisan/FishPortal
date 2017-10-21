package com.github.ppartisan.fishportal.search;

import android.arch.lifecycle.ViewModelProviders;

import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class SearchActivityModule {
    @Provides static SearchItemViewModel searchItemViewModel(SearchActivity activity) {
        return ViewModelProviders.of(activity).get(SearchItemViewModel.class);
    }
}
