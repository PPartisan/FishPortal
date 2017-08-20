package com.github.ppartisan.fishportal.util.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import static com.github.ppartisan.fishportal.BuildConfig.DEBUG;
import static java.lang.String.format;

public class TextWatcherAdapter implements TextWatcher {

    private static final String TAG = TextWatcherAdapter.class.getSimpleName();

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(DEBUG) {
            Log.i(TAG, format(
                    "%s::beforeTextChanged - CharSequence '%s', start '%d', count '%d', after '%d'",
                    TAG, charSequence, i, i1, i2)
            );
        }
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(DEBUG) {
            Log.i(TAG, format(
                    "%s::onTextChanged - CharSequence '%s', start '%d', before '%d', count '%d'",
                    TAG, charSequence, i, i1, i2)
            );
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(DEBUG) {
            Log.i(TAG, format("%s::afterTextChanged - Editable '%s'", TAG, editable));
        }
    }

}
