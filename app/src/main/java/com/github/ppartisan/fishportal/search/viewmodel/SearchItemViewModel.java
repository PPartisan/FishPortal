package com.github.ppartisan.fishportal.search.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.github.ppartisan.fishportal.model.search.SearchItem;

import java.util.List;

public class SearchItemViewModel extends ViewModel {

    public final MutableLiveData<List<SearchItem>> items = new MutableLiveData<>();

}
