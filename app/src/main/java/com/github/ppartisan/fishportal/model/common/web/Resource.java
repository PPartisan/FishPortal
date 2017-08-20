package com.github.ppartisan.fishportal.model.common.web;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.github.ppartisan.fishportal.model.common.web.Status.ERROR;
import static com.github.ppartisan.fishportal.model.common.web.Status.LOADING;
import static com.github.ppartisan.fishportal.model.common.web.Status.SUCCESS;

public class Resource<T> {

    public final @Status int status;
    @Nullable public final T data;
    @Nullable public final String message;

    private Resource(@Status int status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String message, @Nullable T data) {
        return new Resource<>(ERROR, data, message);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

}
