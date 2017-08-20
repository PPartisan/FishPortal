package com.github.ppartisan.fishportal.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.github.ppartisan.fishportal.R;
import com.github.ppartisan.fishportal.di.activity.BaseActivity;
import com.github.ppartisan.fishportal.di.activity.HasActivitySubComponentBuilders;

public class SearchActivity extends BaseActivity {

    private SearchComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_search);
        component.inject((SearchFragment)getSupportFragmentManager().findFragmentById(R.id.search_fragment));
    }

    @Override
    protected void injectMembers(HasActivitySubComponentBuilders hasActivitySubComponentBuilders) {
        component = ((SearchComponent.Builder) hasActivitySubComponentBuilders
                .getActivityComponentBuilder(SearchActivity.class))
                .activityModule(new SearchModule(this))
                .build();
        component.injectMembers(this);
    }

}
