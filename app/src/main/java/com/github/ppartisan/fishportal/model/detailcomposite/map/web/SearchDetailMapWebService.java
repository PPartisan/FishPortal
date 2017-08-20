package com.github.ppartisan.fishportal.model.detailcomposite.map.web;

import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface SearchDetailMapWebService {
    @GET("comnames")
    Call<SearchDetailMapItem> getMapItem(@Query("autoctr") long autoctr);
}
