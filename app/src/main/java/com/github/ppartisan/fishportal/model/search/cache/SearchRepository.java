package com.github.ppartisan.fishportal.model.search.cache;

import android.support.annotation.NonNull;

import com.github.ppartisan.fishportal.model.common.annotation.executor.SingleThread;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.model.search.SearchRepositoryListener;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.github.ppartisan.fishportal.util.CollectionUtils.isEmpty;

@Singleton
public class SearchRepository {

    private final SearchDao dao;
    private final Executor executor;

    @Inject
    SearchRepository(SearchDao dao, @SingleThread Executor executor) {
        this.dao = dao;
        this.executor = executor;
    }

    public void load(final String commonName, @NonNull final SearchRepositoryListener listener) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                listener.onComplete(dao.load(commonName));
            }
        });
    }

    public void put(final List<SearchItem> items) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if(!isEmpty(items)) {
                    dao.save(items);
                }
            }
        });
    }

}
