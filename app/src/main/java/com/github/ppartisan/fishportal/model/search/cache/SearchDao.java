package com.github.ppartisan.fishportal.model.search.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.github.ppartisan.fishportal.model.search.SearchItem;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface SearchDao {
    @Insert(onConflict = REPLACE)
    void save(List<SearchItem> items);
    @Query("SELECT * FROM search WHERE name LIKE '%' || :name || '%'")
    List<SearchItem> load(String name);
}
