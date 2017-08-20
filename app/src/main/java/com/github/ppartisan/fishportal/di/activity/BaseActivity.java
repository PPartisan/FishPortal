package com.github.ppartisan.fishportal.di.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.ppartisan.fishportal.FishPortalApp;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpActivityComponent();
    }

    public void setUpActivityComponent() {
        injectMembers(FishPortalApp.get(this));
    }

    protected abstract void injectMembers(HasActivitySubComponentBuilders hasActivitySubComponentBuilders);

}
