package com.github.ppartisan.fishportal.model.detailcomposite.detail;

import com.github.ppartisan.fishportal.model.common.data.CacheDatabase;
import com.github.ppartisan.fishportal.model.common.data.DataModule;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.cache.DetailDao;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.web.SpeciesWebModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DataModule.class,
        SpeciesWebModule.class
})
public abstract class DetailModule {
    @Provides @Singleton static DetailDao detailDao(CacheDatabase cacheDatabase) {
        return cacheDatabase.detailDao();
    }
}
