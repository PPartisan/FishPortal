package com.github.ppartisan.fishportal.model.search;

import com.github.ppartisan.fishportal.model.common.data.CacheDatabase;
import com.github.ppartisan.fishportal.model.common.data.DataModule;
import com.github.ppartisan.fishportal.model.search.cache.SearchDao;
import com.github.ppartisan.fishportal.model.search.web.SearchWebModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DataModule.class,
        SearchWebModule.class
})
public abstract class SearchModelModule {
    @Provides @Singleton static SearchDao cacheDao(CacheDatabase cacheDatabase) {
        return cacheDatabase.cacheDao();
    }
}
