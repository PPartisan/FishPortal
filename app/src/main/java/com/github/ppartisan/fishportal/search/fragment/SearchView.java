package com.github.ppartisan.fishportal.search.fragment;

import com.github.ppartisan.fishportal.model.search.SearchItem;

import java.util.List;

interface SearchView {
    void setSearchItems(List<SearchItem> items);
}
