package com.github.ppartisan.fishportal.di.activity;

import android.support.v4.app.FragmentActivity;

import dagger.MembersInjector;

public interface ActivityComponent<A extends FragmentActivity> extends MembersInjector<A> {}
