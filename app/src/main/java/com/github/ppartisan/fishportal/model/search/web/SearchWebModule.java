package com.github.ppartisan.fishportal.model.search.web;

import com.github.ppartisan.fishportal.model.common.annotation.Search;
import com.github.ppartisan.fishportal.model.common.web.WebModule;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

@Module(includes = WebModule.class)
public abstract class SearchWebModule {
    @Provides @Reusable static CommonNameWebService commonNameWebService(@Search Retrofit retrofit) {
        return retrofit.create(CommonNameWebService.class);
    }
}
