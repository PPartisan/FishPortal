package com.github.ppartisan.fishportal.model.search;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "search")
public final class SearchItem {

    @PrimaryKey @SerializedName("autoctr") private final long id;
    @SerializedName("comname") private final String name;

    public SearchItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
