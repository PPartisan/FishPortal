package com.github.ppartisan.fishportal.search.recycler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil.Callback;

import com.github.ppartisan.fishportal.model.search.SearchItem;

import java.util.ArrayList;
import java.util.List;

class SearchDiffUtil extends Callback {

    @NonNull private final List<SearchItem> newItems;
    @NonNull private final List<SearchItem> oldItems;

    SearchDiffUtil(@Nullable List<SearchItem> newItems, @Nullable List<SearchItem> oldItems) {
        this.newItems = newItems == null ? new ArrayList<>() : newItems;
        this.oldItems = oldItems == null ? new ArrayList<>() : oldItems;
    }

    @Override
    public int getOldListSize() {
        return oldItems.size();
    }

    @Override
    public int getNewListSize() {
        return newItems.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItems.get(oldItemPosition).getId() == newItems.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return areItemsTheSame(oldItemPosition, newItemPosition);
    }

}
