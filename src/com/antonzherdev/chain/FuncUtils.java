package com.antonzherdev.chain;

public class FuncUtils {
    public static <X> X firstNotNull(X... items) {
        for(X item : items) {
            if(item != null) return item;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> int compare(T o1, T o2) {
        if(o1 == null && o2 == null) return 0;
        if(o1 == null) return -1;
        if(o2 == null) return 1;
        return ((Comparable<T>)o1).compareTo(o2);
    }
    
    public static <T> B<T> not(final B<T> predicate) {
        return new B<T>() {
            @Override
            public Boolean f(T x) {
                return !predicate.f(x);
            }
        };
    }
    
    public static <T> B<T> and(final B<T> b1, final B<T> b2) {
        return new B<T>() {
            @Override
            public Boolean f(T x) {
                return b1.f(x) && b2.f(x);
            }
        };
    }
    
    public static <T> B<T> or(final B<T> b1, final B<T> b2) {
        return new B<T>() {
            @Override
            public Boolean f(T x) {
                return b1.f(x) || b2.f(x);
            }
        };
    }

    public static <A, B, R> F<B, R> curry(final A a, final F2<A, B, R> f) {
        return new F<B, R>() {
            @Override
            public R f(B b) {
                return f.f(a, b);
            }
        };
    }
}
