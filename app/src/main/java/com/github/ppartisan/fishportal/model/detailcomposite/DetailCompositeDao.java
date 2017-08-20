package com.github.ppartisan.fishportal.model.detailcomposite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

@Dao
public interface DetailCompositeDao {
    @Query("SELECT * FROM search_detail_map " +
            "INNER JOIN detail ON map_speciesCode = speciesCode " +
            "WHERE autoCtr = :autoCtr")
    DetailCompositeItem getItem(long autoCtr);
}
