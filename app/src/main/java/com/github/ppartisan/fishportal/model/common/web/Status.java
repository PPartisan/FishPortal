package com.github.ppartisan.fishportal.model.common.web;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.github.ppartisan.fishportal.model.common.web.Status.ERROR;
import static com.github.ppartisan.fishportal.model.common.web.Status.LOADING;
import static com.github.ppartisan.fishportal.model.common.web.Status.SUCCESS;

@Retention(RetentionPolicy.SOURCE)
@IntDef({SUCCESS,LOADING,ERROR})
public @interface Status {
    int SUCCESS = 0;
    int LOADING = 1;
    int ERROR = 2;
}
