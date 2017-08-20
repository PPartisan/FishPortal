package com.github.ppartisan.fishportal.model.detailcomposite.detail.web;


import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface SpeciesWebService {
    @GET("species/{SpecCode}/")
    Call<DetailItem> getItems(@Path("SpecCode") long specCode);
}
