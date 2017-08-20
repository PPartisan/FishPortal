package com.github.ppartisan.fishportal.search.recycler;


import android.support.v7.widget.RecyclerView;

import com.github.ppartisan.fishportal.databinding.RowSearchBinding;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.search.SearchPresenter;

class SearchItemViewHolder extends RecyclerView.ViewHolder {

    private final RowSearchBinding binding;

    SearchItemViewHolder(RowSearchBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(SearchItem item, SearchPresenter presenter) {
        binding.setItem(item);
        binding.setPresenter(presenter);
        binding.executePendingBindings();
    }

}
