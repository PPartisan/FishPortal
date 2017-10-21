package com.github.ppartisan.fishportal.util.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import static com.github.ppartisan.fishportal.BuildConfig.DEBUG;
import static java.lang.String.format;

public abstract class TextWatcherAdapter implements TextWatcher {

    private static final String DEFAULT_TAG = TextWatcherAdapter.class.getSimpleName();

    private final String tag;

    protected TextWatcherAdapter() {
        this(DEFAULT_TAG);
    }

    protected TextWatcherAdapter(String tag) {
        this.tag = tag;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(DEBUG) {
            Log.i(tag, format(
                    "%s::beforeTextChanged - CharSequence '%s', start '%d', count '%d', after '%d'",
                    tag, charSequence, i, i1, i2)
            );
        }
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(DEBUG) {
            Log.i(tag, format(
                    "%s::onTextChanged - CharSequence '%s', start '%d', before '%d', count '%d'",
                    tag, charSequence, i, i1, i2)
            );
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(DEBUG) {
            Log.i(tag, format("%s::afterTextChanged - Editable '%s'", tag, editable));
        }
    }

}
