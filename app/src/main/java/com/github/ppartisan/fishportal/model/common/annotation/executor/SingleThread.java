package com.github.ppartisan.fishportal.model.common.annotation.executor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.SOURCE)
public @interface SingleThread {}
