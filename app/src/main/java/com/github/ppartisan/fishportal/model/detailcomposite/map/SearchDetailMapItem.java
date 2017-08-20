package com.github.ppartisan.fishportal.model.detailcomposite.map;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(
        tableName = "search_detail_map",
        indices = {@Index(value = {"map_speciesCode"}, unique = true)}
)
public class SearchDetailMapItem {

    @PrimaryKey @SerializedName("autoctr") private final long autoCtr;
    @SerializedName("SpecCode") @ColumnInfo(name = "map_speciesCode") private final long speciesCode;

    public SearchDetailMapItem(long autoCtr, long speciesCode) {
        this.autoCtr = autoCtr;
        this.speciesCode = speciesCode;
    }

    public long getAutoCtr() {
        return autoCtr;
    }

    public long getSpeciesCode() {
        return speciesCode;
    }

}
