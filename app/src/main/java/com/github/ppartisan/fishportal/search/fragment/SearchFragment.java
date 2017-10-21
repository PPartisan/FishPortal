package com.github.ppartisan.fishportal.search.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ppartisan.fishportal.R;
import com.github.ppartisan.fishportal.databinding.FragmentSearchBinding;
import com.github.ppartisan.fishportal.model.search.SearchItem;
import com.github.ppartisan.fishportal.search.recycler.SearchItemAdapter;
import com.github.ppartisan.fishportal.search.viewmodel.SearchItemViewModel;
import com.github.ppartisan.fishportal.util.adapter.TextWatcherAdapter;
import com.github.ppartisan.fishportal.util.view.VerticalSpaceItemDecoration;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

import static android.databinding.DataBindingUtil.inflate;

public class SearchFragment extends Fragment implements SearchView {

    @Inject SearchPresenter presenter;
    @Inject SearchItemAdapter adapter;

    @Inject SearchItemViewModel viewModel;

    private FragmentSearchBinding binding;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

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

        binding.fsSearch.addTextChangedListener(new TextWatcherAdapter("ppartisan") {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.onSearchTextUpdated(editable.toString());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        binding.setPresenter(presenter);
        viewModel.items.observe(this, presenter::onSearchItemsUpdate);
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.setPresenter(null);
        viewModel.items.removeObservers(this);
    }

    @Override
    public void setSearchItems(List<SearchItem> items) {
        adapter.setItems(items);
    }

}
