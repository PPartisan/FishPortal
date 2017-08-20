package com.github.ppartisan.fishportal.model.detailcomposite.detail.cache;

import com.github.ppartisan.fishportal.model.common.annotation.executor.SingleThread;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DetailRepository {
    private final DetailDao dao;
    private final Executor executor;

    @Inject DetailRepository(DetailDao dao, @SingleThread Executor executor) {
        this.dao = dao;
        this.executor = executor;
    }

    public void put(final DetailItem item) {
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
