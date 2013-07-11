package com.antonzherdev.chain;

import com.antonzherdev.chain.Tuple;

import java.util.Iterator;
import java.util.Map;

public class MapIterable<K, V> implements Iterable<Tuple<K, V>> {
    private final Map<K, V> map;

    public MapIterable(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public Iterator<Tuple<K, V>> iterator() {
        return new Iterator<Tuple<K, V>>() {
            Iterator<Map.Entry<K, V>> i = map.entrySet().iterator();
            
            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Tuple<K, V> next() {
                Map.Entry<K, V> next = i.next();
                return Tuple.tuple(next.getKey(), next.getValue());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
