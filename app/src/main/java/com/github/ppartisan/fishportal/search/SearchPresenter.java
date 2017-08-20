package com.github.ppartisan.fishportal.search;
import android.util.Log;

import com.github.ppartisan.fishportal.model.detailcomposite.DetailListener;
import com.github.ppartisan.fishportal.model.detailcomposite.DetailOperations;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.model.search.SearchRepositoryListener;
import com.github.ppartisan.fishportal.model.search.cache.SearchRepository;
import com.github.ppartisan.fishportal.model.search.web.SearchWebRepository;
import com.github.ppartisan.fishportal.mvp.BasePresenter;
import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.text.TextUtils.isEmpty;

public class SearchPresenter extends BasePresenter<SearchView>{

    private final Callbacks callbacks;
    private final SearchWebRepository web;
    private final SearchRepository cache;

    private final DetailOperations detail;

    @Inject SearchPresenter(Callbacks callbacks, SearchWebRepository web, SearchRepository cache, DetailOperations detail) {
        this.callbacks = callbacks;
        this.web = web;
        this.cache = cache;
        this.detail = detail;
    }

    void onSearchTextUpdated(String searchTerm) {
        if(isEmpty(searchTerm)) {
            view.setSearchItems(new ArrayList<SearchItem>());
        } else {
            cache.load(searchTerm, callbacks);
        }
    }

    public void onSearchClick(String searchTerm) {
        web.refresh(searchTerm, callbacks);
    }

    public void onSearchItemClick(final SearchItem item) {
        detail.refresh(item.getId(), new DetailListener() {
            @Override
            public void onComplete(DetailItem item) {
                if(item != null) {
                    Log.d("PPartisan", String.format("Comments '%s'", item.getComments()));
                }
            }
        });
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

}
