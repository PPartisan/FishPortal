package com.github.ppartisan.fishportal.model.common.data;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DataModule {

    private static final String DATABASE_NAME = "fish_portal.db";

    @Provides @Singleton static CacheDatabase cacheDatabase(Context context) {
        return Room.databaseBuilder(
                context,
                CacheDatabase.class,
                DATABASE_NAME
        ).build();
    }

}
