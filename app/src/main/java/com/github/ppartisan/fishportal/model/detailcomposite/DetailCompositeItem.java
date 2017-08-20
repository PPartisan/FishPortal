package com.github.ppartisan.fishportal.model.detailcomposite;

import android.arch.persistence.room.Embedded;

import com.github.ppartisan.fishportal.model.detailcomposite.detail.DetailItem;
import com.github.ppartisan.fishportal.model.detailcomposite.map.SearchDetailMapItem;

public class DetailCompositeItem {

    @Embedded private final SearchDetailMapItem map;
    @Embedded private final DetailItem item;

    public DetailCompositeItem(SearchDetailMapItem map, DetailItem item) {
        this.map = map;
        this.item = item;
    }

    public SearchDetailMapItem getMap() {
        return map;
    }

    public DetailItem getItem() {
        return item;
    }

}
