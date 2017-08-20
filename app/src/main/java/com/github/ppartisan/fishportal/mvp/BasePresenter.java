package com.github.ppartisan.fishportal.mvp;

public abstract class BasePresenter<V> {

    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

}
