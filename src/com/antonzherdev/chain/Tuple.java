package com.antonzherdev.chain;

import java.util.Map;

public class Tuple<T1, T2> implements Comparable, Map.Entry<T1, T2> {
    final public T1 _1;
    final public T2 _2;

    public static <U> F<Tuple<U, ?>, U> first() {
        return new F<Tuple<U, ?>, U>() {
            @Override
            public U f(Tuple<U, ?> t) {
                return t._1;
            }
        };
    }

    public static <U> F<Tuple<?, U>, U> second() {
        return new F<Tuple<?, U>, U>() {
            @Override
            public U f(Tuple<?, U> t) {
                return t._2;
            }
        };
    }

    public Tuple(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public static <T1, T2> Tuple<T1, T2> tuple(T1 _1, T2 _2) {
        return new Tuple<T1, T2>(_1, _2);
    }

    @Override
    public T1 getKey() {
        return _1;
    }

    @Override
    public T2 getValue() {
        return _2;
    }

    @Override
    public T2 setValue(T2 value) {
        throw new UnsupportedOperationException("Tuple is immutable object");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;

        Tuple tuple = (Tuple) o;

        if (_1 != null ? !_1.equals(tuple._1) : tuple._1 != null) return false;
        if (_2 != null ? !_2.equals(tuple._2) : tuple._2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _1 != null ? _1.hashCode() : 0;
        result = 31 * result + (_2 != null ? _2.hashCode() : 0);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Object o) {
        if(o instanceof Tuple) {
            Tuple t = (Tuple)o;
            int r = ((Comparable)_1).compareTo(t._1);
            if(r == 0) {
                r = ((Comparable)_2).compareTo(t._2);
            }
            return r;
        }
        if(o == null) throw new IllegalArgumentException("Not supported null");
        throw new IllegalArgumentException("Not supported class " + o.getClass());
    }

    @Override
    public String toString() {
        return "<" + _1 + ", " + _2 + ">";
    }
}
