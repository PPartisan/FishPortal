package com.github.ppartisan.fishportal.model.detailcomposite.map.web;

import android.support.annotation.NonNull;

import com.github.ppartisan.fishportal.model.detailcomposite.map.MapRepositoryListener;
import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;
import com.github.ppartisan.fishportal.model.detailcomposite.map.cache.MapRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SearchDetailWebRepository {

    private final SearchDetailMapWebService service;
    private final MapRepository cache;

    @Inject SearchDetailWebRepository(SearchDetailMapWebService service, MapRepository cache) {
        this.service = service;
        this.cache = cache;
    }

    public void refresh(final long autoctr, @NonNull final MapRepositoryListener listener) {
        service.getMapItem(autoctr).enqueue(new Callback<SearchDetailMapItem>() {
            @Override
            public void onResponse(
                    @NonNull Call<SearchDetailMapItem> call,
                    @NonNull Response<SearchDetailMapItem> response
            ) {
                final SearchDetailMapItem item = response.body();
                if(item != null) {
                    cache.put(item);
                    listener.onComplete(item.getSpeciesCode());
                }
            }

            @Override
            public void onFailure(
                    @NonNull Call<SearchDetailMapItem> call,
                    @NonNull Throwable t
            ) {

            }
        });
    }

}
