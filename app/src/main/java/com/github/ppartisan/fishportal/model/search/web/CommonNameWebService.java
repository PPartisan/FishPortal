package com.github.ppartisan.fishportal.model.search.web;

import com.github.ppartisan.fishportal.model.search.SearchItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface CommonNameWebService {
    @GET("cname/letter/{common_name}")
    Call<List<SearchItem>> getSearchItems(@Path("common_name") String commonName);
}
