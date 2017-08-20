package com.github.ppartisan.fishportal.model.common.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.github.ppartisan.fishportal.model.detailcomposite.DetailCompositeDao;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.detailcomposite.detail.cache.DetailDao;
import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;
import com.github.ppartisan.fishportal.model.detailcomposite.map.cache.MapDao;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.model.search.cache.SearchDao;

@Database(entities = {
        DetailItem.class,
        SearchDetailMapItem.class,
        SearchItem.class
}, version = 1)
public abstract class CacheDatabase extends RoomDatabase {
    public abstract SearchDao cacheDao();
    public abstract MapDao mapDao();
    public abstract DetailDao detailDao();
    public abstract DetailCompositeDao compositeDao();
}
