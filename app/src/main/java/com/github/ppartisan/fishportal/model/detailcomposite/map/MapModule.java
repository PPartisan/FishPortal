package com.github.ppartisan.fishportal.model.detailcomposite.map;

import com.github.ppartisan.fishportal.model.common.data.CacheDatabase;
import com.github.ppartisan.fishportal.model.common.data.DataModule;
import com.github.ppartisan.fishportal.model.detailcomposite.map.cache.MapDao;
import com.github.ppartisan.fishportal.model.detailcomposite.map.web.SearchDetailWebModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DataModule.class,
        SearchDetailWebModule.class
})
public abstract class MapModule {
    @Provides @Singleton static MapDao mapDao(CacheDatabase cacheDatabase) {
        return cacheDatabase.mapDao();
    }
}
