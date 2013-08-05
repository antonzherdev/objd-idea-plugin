package com.antonzherdev.chain;


import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("UnusedDeclaration")
public abstract class Option<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1854340604207495407L;

    public abstract T get();
    public abstract boolean isEmpty();
    public final boolean isDefined() { return !isEmpty(); }

    @SuppressWarnings("unchecked")
    public static <R> Option<R> none() {
        return (Option<R>) NONE;
    }

    public static <R> Option<R> some(R value) {
        return new Some<R>(value);
    }

    public static final Option<?> NONE = new None();

    public static <R> Option<R> opt(R v) {
        if(v == null) return none();
        return some(v);
    }

    public static <R> Option<R> fromNullable(R v) {
        return opt(v);
    }

    public static <R> Option<R> opt(boolean some, R v) {
        return some ? some(v) : Option.<R>none();
    }

    public static <R> Option<R> fromList(Iterable<R> list) {
        Iterator<R> i = list.iterator();
        if(i.hasNext()) return some(i.next());
        return none();
    }

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Option)) return false;

        Option some = (Option) o;
        if(isEmpty()) return some.isEmpty();

        T value = get();
        Object sv = some.get();
        if (value != null ? !value.equals(sv) : sv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        if(isEmpty()) return 13;
        T value = get();
        return 17 + 19*(value != null ? value.hashCode() : 0);
    }

    @Override
    public String toString() {
        return isEmpty() ? "None" : "Some(" + get() + ")";
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            boolean first = true;
            @Override
            public boolean hasNext() {
                return first && !isEmpty();
            }

            @Override
            public T next() {
                if(!hasNext()) throw new IllegalStateException();
                first = false;
                return get();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Option<T> orElse(Option<T> alt) {
        return isEmpty() ? alt : this;
    }

    public Option<T> orElse(F0<Option<T>> alt) {
        return isEmpty() ? alt.f() : this;
    }

    @SuppressWarnings("unchecked")
    public IChain<T> chain() {
        if(isEmpty()) return Chain.empty();
        else return Chain.chain(get());
    }

    public static final class Some<T> extends Option<T> {
        private static final long serialVersionUID = 3007374559858805953L;
        private final T value;

        public Some(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @SuppressWarnings("unchecked")
        @Override
        public IChain<T> chain() {
            return Chain.chain(value);
        }
    }

    public static final class None extends Option<Object> {
        private static final long serialVersionUID = 2065953330994194330L;

        @Override
        public Object get() {
            throw new IllegalStateException("Empty option value");
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public IChain<Object> chain() {
            return Chain.empty();
        }
    }

    public final T getOrElse(T def) {
        if(isEmpty()) return def;
        return get();
    }

    public final T getOrElse(F0<T> f) {
        if(isEmpty()) return f.f();
        return get();
    }

    public void foreach(P<T> p) {
        if(isDefined()) {
            p.p(get());
        }
    }

    public <X> Option<X> map(F<T, X> f) {
        if(isEmpty()) return none();
        return some(f.f(get()));
    }

    public T getOrNull() {
        if(isEmpty()) return null;
        return get();
    }
}
