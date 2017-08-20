package com.github.ppartisan.fishportal.model.detailcomposite;

import com.github.ppartisan.fishportal.model.common.data.CacheDatabase;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailModule;
import com.github.ppartisan.fishportal.model.detailcomposite.map.MapModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DetailModule.class,
        MapModule.class
})
public abstract class DetailCompositeModule {
    @Provides @Singleton static DetailCompositeDao detailCompositeDao(CacheDatabase cacheDatabase) {
        return cacheDatabase.compositeDao();
    }
}
