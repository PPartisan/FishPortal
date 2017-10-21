package com.github.ppartisan.fishportal.model.detailcomposite.detail.web;

import android.support.annotation.NonNull;

import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailRepositoryListener;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.cache.DetailRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpeciesWebRepository {

    private final SpeciesWebService service;

    private final DetailRepository cache;

    @Inject SpeciesWebRepository(SpeciesWebService service, DetailRepository cache) {
        this.service = service;
        this.cache = cache;
    }

    public void refresh(final long speciesCode, @NonNull final DetailRepositoryListener listener) {
        service.getItems(speciesCode).enqueue(
                new Callback<DetailItem>() {
                    @Override
                    public void onResponse(
                            @NonNull Call<DetailItem> call,
                            @NonNull Response<DetailItem> response
                    ) {
                        final DetailItem item = response.body();
                        if(item != null) {
                            cache.put(item);
                            listener.onComplete(item);
                        }
                    }

                    @Override
                    public void onFailure(
                            @NonNull Call<DetailItem> call,
                            @NonNull Throwable t
                    ) {
                        //todo Handle failures
                    }
                });
    }

}
