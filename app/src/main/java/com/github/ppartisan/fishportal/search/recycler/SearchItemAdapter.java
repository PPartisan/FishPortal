package com.github.ppartisan.fishportal.search.recycler;

import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.ppartisan.fishportal.databinding.RowSearchBinding;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.search.fragment.SearchPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.support.v7.util.DiffUtil.calculateDiff;
import static com.github.ppartisan.fishportal.databinding.RowSearchBinding.inflate;
import static com.github.ppartisan.fishportal.util.CollectionUtils.isEqual;

public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {

    private final LayoutInflater inflater;
    private final SearchPresenter presenter;

    private List<SearchItem> items;

    @Inject SearchItemAdapter(LayoutInflater inflater, SearchPresenter presenter) {
        this.inflater = inflater;
        this.presenter = presenter;
        this.items = new ArrayList<>();
    }

    @Override
    public SearchItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RowSearchBinding binding = inflate(inflater, parent, false);
        return new SearchItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(SearchItemViewHolder holder, final int position) {
        holder.bind(items.get(position), presenter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<SearchItem> newItems) {
        if(!isEqual(items, newItems)) {
            final DiffResult result = calculateDiff(new SearchDiffUtil(newItems, items));
            items.clear();
            items.addAll(newItems);
            result.dispatchUpdatesTo(this);
        }
    }

}
