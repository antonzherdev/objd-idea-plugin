package com.antonzherdev.chain;

import java.util.UUID;

public class CompareUtils {
    @SuppressWarnings("unchecked")
    public static int compare(Object o1, Object o2) {
        if(o1 == o2) return 0;
        if(o1 == null) return 1;
        if(o2 == null) return -1;
        if((o1 instanceof UUID) && (o2 instanceof UUID)) {
            return uuidCompare((UUID)o1, (UUID)o2);
        }
        return ((Comparable)o1).compareTo(o2);
    }

    /**
     * @return
     *  o1 == o2 -> 0<br/>
     *  o1 == null -> 1<br/>
     *  o2 == null -> -1<br/>
     *  else 0<br/>
     */
    public static int compareNullOnly(Object o1, Object o2) {
        if(o1 == o2) return 0;
        if(o1 == null) return 1;
        if(o2 == null) return -1;
        return 0;
    }

    public static int uuidCompare(UUID o1, UUID o2) {
        long l1 = o1.getMostSignificantBits();
        long l2 = o2.getMostSignificantBits();
        int c = ulongCompare(l1, l2);
        return c != 0 ? c : ulongCompare(o1.getLeastSignificantBits(), o2.getLeastSignificantBits());
    }

    public static int ulongCompare(long l1, long l2) {
        if(l1 == l2) return 0;
        if(l1 < 0 && l2 > 0) return 1;
        if(l1 > 0 && l2 < 0) return -1;
        return l1 < l2 ? -1 : 1;
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
