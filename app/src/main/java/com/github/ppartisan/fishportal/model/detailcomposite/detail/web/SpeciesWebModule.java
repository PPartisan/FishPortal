package com.github.ppartisan.fishportal.model.detailcomposite.detail.web;

import com.github.ppartisan.fishportal.model.common.annotation.Detail;
import com.github.ppartisan.fishportal.model.common.web.WebModule;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

@Module(includes = WebModule.class)
public abstract class SpeciesWebModule {
    @Provides @Reusable static SpeciesWebService commonNameWebService(@Detail Retrofit retrofit) {
        return retrofit.create(SpeciesWebService.class);
    }
}
