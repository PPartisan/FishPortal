package com.github.ppartisan.fishportal.search.fragment;

import com.github.ppartisan.fishportal.model.detailcomposite.DetailOperations;
import com.github.ppartisan.fishportal.model.search.cache.SearchRepository;
import com.github.ppartisan.fishportal.model.search.web.SearchWebRepository;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class SearchFragmentModule {

    @Provides static SearchView searchView(SearchFragment searchFragment) {
        return searchFragment;
    }

    @Provides static SearchPresenter searchPresenter(
            SearchView view,
            SearchPresenter.Callbacks callbacks,
            SearchWebRepository webRepository,
            SearchRepository repository,
            DetailOperations detailOperations
    ) {
        return new SearchPresenter(
                view, callbacks, webRepository, repository, detailOperations);
    }

}
