package com.github.ppartisan.fishportal.search;

import com.github.ppartisan.fishportal.di.activity.ActivityComponent;
import com.github.ppartisan.fishportal.di.activity.ActivityComponentBuilder;
import com.github.ppartisan.fishportal.di.activity.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = SearchModule.class)
public interface SearchComponent extends ActivityComponent<SearchActivity>{

    void inject(SearchFragment fragment);

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SearchModule, SearchComponent> {}

}
