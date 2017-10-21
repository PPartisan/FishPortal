package com.github.ppartisan.fishportal.search.fragment;

import android.util.Log;

import com.github.ppartisan.fishportal.model.detailcomposite.DetailOperations;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.model.search.SearchRepositoryListener;
import com.github.ppartisan.fishportal.model.search.cache.SearchRepository;
import com.github.ppartisan.fishportal.model.search.web.SearchWebRepository;
import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static android.text.TextUtils.isEmpty;

public class SearchPresenter {

    private final SearchView view;
    private final Callbacks callbacks;
    private final SearchWebRepository web;
    private final SearchRepository cache;

    private final DetailOperations detail;

    @Inject SearchPresenter(SearchView view, Callbacks callbacks, SearchWebRepository web, SearchRepository cache, DetailOperations detail) {
        this.view = view;
        this.callbacks = callbacks;
        this.web = web;
        this.cache = cache;
        this.detail = detail;
    }

    void onSearchTextUpdated(String searchTerm) {
        if(isEmpty(searchTerm)) {
            view.setSearchItems(new ArrayList<>());
        } else {
            cache.load(searchTerm, callbacks);
        }
    }

    public void onSearchClick(String searchTerm) {
        web.refresh(searchTerm, callbacks);
    }

    public void onSearchItemClick(final SearchItem searchItem) {
        detail.refresh(searchItem.getId(),SearchPresenter::printComments);
    }

    void onSearchItemsUpdate(List<SearchItem> items) {
        view.setSearchItems(items);
    }

    @SuppressWarnings("WeakerAccess")
    static final class Callbacks implements SearchRepositoryListener {

        private final SearchItemViewModel viewModel;

        @Inject Callbacks(SearchItemViewModel viewModel) {
            this.viewModel = viewModel;
        }

        @Override
        public void onComplete(List<SearchItem> items) {
            viewModel.items.postValue(items);
        }

    }

    private static void printComments(@Nullable DetailItem item) {
        if(item != null) {
            Log.d("PPartisan", String.format("Comments '%s'", item.getComments()));
        }
    }

}
