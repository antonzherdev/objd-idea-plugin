package com.antonzherdev.chain;

public class MutableOption<T> extends Option<T> {
    private static final long serialVersionUID = 1304687114070296602L;
    private boolean empty = true;
    private T item;

    @Override
    public T get() {
        if(empty) throw new IllegalStateException("Empty option value");
        return item;
    }

    @Override
    public boolean isEmpty() {
        return empty;
    }

    public void set(T item) {
        this.item = item;
        this.empty = false;
    }

    public void clear() {
        this.empty = true;
        this.item = null;
    }
}
