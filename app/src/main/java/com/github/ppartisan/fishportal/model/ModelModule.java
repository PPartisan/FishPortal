package com.github.ppartisan.fishportal.model;

import com.github.ppartisan.fishportal.model.common.annotation.executor.SingleThread;
import com.github.ppartisan.fishportal.model.detailcomposite.DetailCompositeModule;
import com.github.ppartisan.fishportal.model.search.SearchModule;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DetailCompositeModule.class,
        SearchModule.class
})
public abstract class ModelModule {
    @Provides @Singleton @SingleThread static Executor executor() {
        return Executors.newSingleThreadExecutor();
    }
}
