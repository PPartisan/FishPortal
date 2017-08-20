package com.github.ppartisan.fishportal.model.detailcomposite.map.cache;

import com.github.ppartisan.fishportal.model.common.annotation.executor.SingleThread;
import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MapRepository {
    private final MapDao dao;
    private final Executor executor;

    @Inject MapRepository(MapDao dao, @SingleThread Executor executor) {
        this.dao = dao;
        this.executor = executor;
    }

    public void put(final SearchDetailMapItem item) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if(item != null) {
                    dao.save(item);
                }
            }
        });
    }
}
