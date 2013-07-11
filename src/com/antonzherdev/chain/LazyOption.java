package com.antonzherdev.chain;

public class LazyOption<T> extends Option<T> {
    private static final long serialVersionUID = 2639646380271962082L;
    private transient F0<Option<T>> f;
    Option<T> value;

    public LazyOption(F0<Option<T>> f) {
        this.f = f;
    }

    public LazyOption() {
    }

    @Override
    public T get() {
        if(value == null) value = f.f();
        return value.get();
    }

    @Override
    public boolean isEmpty() {
        if(value == null) value = f.f();
        return value.isEmpty();
    }
}
