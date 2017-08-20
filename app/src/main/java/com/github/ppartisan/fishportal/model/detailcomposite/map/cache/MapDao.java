package com.github.ppartisan.fishportal.model.detailcomposite.map.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MapDao {
    @Insert(onConflict = REPLACE) void save(SearchDetailMapItem item);
}
