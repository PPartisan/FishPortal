package com.github.ppartisan.fishportal.model.detailcomposite.detail.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DetailDao {
    @Insert(onConflict = REPLACE) void save(DetailItem item);
}
