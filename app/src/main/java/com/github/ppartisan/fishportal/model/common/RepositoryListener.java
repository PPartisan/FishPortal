package com.github.ppartisan.fishportal.model.common;

public interface RepositoryListener<T> {
    void onComplete(T items);
}
