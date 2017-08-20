package com.github.ppartisan.fishportal.util;

import java.util.Collection;

public final class CollectionUtils {

    private CollectionUtils() { throw new AssertionError(); }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isEqual(Collection<T> c1, Collection<T> c2) {
        return c1 == null && c2 == null || c1 != null && c1.equals(c2);
    }

}
