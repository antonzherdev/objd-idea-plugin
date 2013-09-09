package com.antonzherdev.chain;

import com.antonzherdev.chain.F0;

public abstract class Lazy<R> implements F0<R> {
    private boolean init;
    private R value;

    public R get() {
        if(!init) {
            value = create();
            init = true;
        }
        return value;
    }

    protected abstract R create();

    public static <R> Lazy<R> valueOf(final R value) {
        return new Lazy<R>() {
            @Override
            protected R create() {
                return value;
            }
        };
    }

    @Override
    public R f() {
        return get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        final R v = get();
        if (o instanceof Lazy) {
            Lazy lazy = (Lazy) o;
            final Object lv = lazy.get();
            return v != null ? v.equals(lv) : lv == null;
        } else {
            if(v == null && o == null) return true;
            if(v != null) {
                return v.equals(o);
            }
            else {
                return o.equals(v);
            }
        }
    }

    @Override
    public int hashCode() {
        final R v = get();
        return v != null ? v.hashCode() : 0;
    }

    public boolean isCreated() {
        return init;
    }
}
