package com.github.ppartisan.fishportal.model.common.web;

import com.github.ppartisan.fishportal.model.common.annotation.Detail;
import com.github.ppartisan.fishportal.model.common.annotation.Search;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class WebModule {

    @Provides @Reusable @Search static Retrofit retrofitSearch() {
        return new Retrofit.Builder()
                .baseUrl("http://www.deepspaceweb.com/fishbase/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides @Reusable @Detail static Retrofit retrofitDetail(@Detail Gson gson) {

        return new Retrofit.Builder()
                .baseUrl("https://fishbase.ropensci.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides @Reusable static FishbaseItemDeserializer<SearchDetailMapItem> mapDeserializer() {
        return FishbaseItemDeserializer.create();
    }

    @Provides @Reusable static FishbaseItemDeserializer<DetailItem> detailDeserializer() {
        return FishbaseItemDeserializer.create();
    }

    @Provides @Reusable @Detail static Gson gson(
            FishbaseItemDeserializer<SearchDetailMapItem> mapDeserializer,
            FishbaseItemDeserializer<DetailItem> detailDeserializer
    ) {
        return new GsonBuilder()
                .registerTypeAdapter(SearchDetailMapItem.class, mapDeserializer)
                .registerTypeAdapter(DetailItem.class, detailDeserializer)
                .create();
    }

}
