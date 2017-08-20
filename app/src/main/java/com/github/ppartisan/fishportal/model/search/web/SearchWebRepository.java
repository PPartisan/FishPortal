package com.github.ppartisan.fishportal.model.search.web;

import android.support.annotation.NonNull;

import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.model.search.SearchRepositoryListener;
import com.github.ppartisan.fishportal.model.search.cache.SearchRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SearchWebRepository {

    private final CommonNameWebService service;

    private final SearchRepository cache;

    @Inject
    SearchWebRepository(CommonNameWebService service, SearchRepository cache) {
        this.service = service;
        this.cache = cache;
    }

    public void refresh(String commonName, @NonNull final SearchRepositoryListener listener) {
        service.getSearchItems(commonName).enqueue(new Callback<List<SearchItem>>() {
            @Override
            public void onResponse(
                    @NonNull Call<List<SearchItem>> call,
                    @NonNull Response<List<SearchItem>> response
            ) {
                final List<SearchItem> items = response.body();
                cache.put(items);
                listener.onComplete(items);
            }

            @Override
            public void onFailure(
                    @NonNull Call<List<SearchItem>> call,
                    @NonNull Throwable t
            ) {

            }
        });
    }

}
