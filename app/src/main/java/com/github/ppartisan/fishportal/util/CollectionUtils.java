package com.github.ppartisan.fishportal.util;

import android.support.annotation.Nullable;

import java.util.Collection;

public final class CollectionUtils {

    private CollectionUtils() { throw new AssertionError(); }

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isEqual(@Nullable Collection<T> c1, @Nullable Collection<T> c2) {
        return c1 == null && c2 == null || c1 != null && c1.equals(c2);
    }

}
