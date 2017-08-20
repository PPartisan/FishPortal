package com.github.ppartisan.fishportal.util.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static com.github.ppartisan.fishportal.util.ViewUtils.dpToPx;

public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public VerticalSpaceItemDecoration() {
        this(dpToPx(4));
    }

    private VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }

}
