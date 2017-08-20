package com.github.ppartisan.fishportal.search;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ppartisan.fishportal.R;
import com.github.ppartisan.fishportal.databinding.FragmentSearchBinding;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.search.recycler.SearchItemAdapter;
import com.github.ppartisan.fishportal.util.view.VerticalSpaceItemDecoration;
import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;
import com.github.ppartisan.fishportal.util.adapter.TextWatcherAdapter;

import java.util.List;

import javax.inject.Inject;

import static android.databinding.DataBindingUtil.inflate;

public class SearchFragment extends LifecycleFragment implements SearchView {

    @Inject SearchPresenter presenter;
    @Inject SearchItemAdapter adapter;

    @Inject SearchItemViewModel viewModel;

    private FragmentSearchBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflate(inflater, R.layout.fragment_search, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.fsRecycler.setAdapter(adapter);
        binding.fsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.fsRecycler.addItemDecoration(new VerticalSpaceItemDecoration());

        binding.fsSearch.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.onSearchTextUpdated(editable.toString());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attach(this);
        binding.setPresenter(presenter);
        viewModel.items.observe(this, new Observer<List<SearchItem>>() {
            @Override
            public void onChanged(@Nullable List<SearchItem> items) {
                presenter.onSearchItemsUpdate(items);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detach();
        viewModel.items.removeObservers(this);
    }

    @Override
    public void setSearchItems(List<SearchItem> items) {
        adapter.setItems(items);
    }

}
