package com.antonzherdev.chain;

import java.util.*;

@SuppressWarnings("unchecked")
public class ChainDelegate<X> implements IChain<X> {
    final Chain<X> base;

    public ChainDelegate(Chain<X> base) {
        this.base = base;
    }

    @Override
    public <C> IChain<C> map(F<? super X, C> f) {
        return base.map(f);
    }

    @Override
    public <C> IChain<C> flatMap(F<? super X, ? extends Iterable<C>> f) {
        return base.flatMap(f);
    }

    @Override
    public <R> IChain<R> flat() {
        return base.flat();
    }

    @Override
    public IChain<X> mapFirst(F<? super X, X> f) {
        return base.mapFirst(f);
    }

    @Override
    public IChain<X> mapLast(F<? super X, X> f) {
        return base.mapLast(f);
    }

    @Override
    public <R> IChain<R> scan(R start, F2<R, X, R> f) {
        return base.scan(start, f);
    }

    @Override
    public <R> IChain<R> unscan(F2<X, X, R> f) {
        return base.unscan(f);
    }

    @Override
    public IChain<X> unscan(Class<X> cls) {
        return base.unscan(cls);
    }

    @Override
    public IChain<X> scan(Class<X> cls) {
        return base.scan(cls);
    }

    @Override
    public IChain<X> filter(F<? super X, Boolean> f) {
        return base.filter(f);
    }

    @Override
    public IChain<X> exclude(Iterable<? extends X> items) {
        return base.exclude(items);
    }

    @Override
    public IChain<X> reverse() {
        return base.reverse();
    }

    @Override
    public IChain<X> reverseIf(boolean b) {
        return base.reverseIf(b);
    }

    @Override
    public IChain<X> window(int start, int count) {
        return base.window(start, count);
    }

    @Override
    public <C> ITupleChain<X,C> zip(Iterable<C> collection) {
        return base.zip(collection);
    }

    @Override
    public List<X> list() {
        return base.list();
    }

    @Override
    public Set<X> set() {
        return base.set();
    }

    @Override
    public Option<X> first() {
        return base.first();
    }

    @Override
    public Option<X> lazyFirstNotNull() {
        return base.lazyFirstNotNull();
    }

    @Override
    public Option<X> firstNotNull() {
        return base.firstNotNull();
    }

    @Override
    public Option<X> find(F<? super X, Boolean> f) {
        return base.find(f);
    }

    @Override
    public <R> R fold(R start, F2<R, X, R> f) {
        return base.fold(start, f);
    }

    @Override
    public void foreach(Yield<X> p) {
        base.foreach(p);
    }

    @Override
    public void foreach(P<X> p) {
        base.foreach(p);
    }

    @Override
    public X sum(Class<X> cls) {
        return base.sum(cls);
    }

    @Override
    public <R extends Number> R sum(Class<R> cls, F<X, R> f) {
        return base.sum(cls, f);
    }

    @Override
    public String getString(String delimiter) {
        return base.getString(delimiter);
    }

    @Override
    public Tuple<Iterable<X>, Iterable<X>> span(F<X, Boolean> f) {
        return base.span(f);
    }

    @Override
    public Option<X> min() {
        return base.min();
    }

    @Override
    public Option<X> max() {
        return base.max();
    }

    @Override
    public void addAllTo(Collection<? super X> collection) {
        base.addAllTo(collection);
    }

    @Override
    public ITupleChain<X,Integer> zipWithIndex() {
        return base.zipWithIndex();
    }

    @Override
    public <Y> ITupleChain<Y, X> zip_1(F<? super X, Y> f) {
        return base.zip_1(f);
    }

    @Override
    public <C> ITupleChain<X,C> zip_2(F<? super X, C> f) {
        return base.zip_2(f);
    }

    @Override
    public <K, V> ITupleChain<K,V> groupFold(F<? super X, K> by, F<? super X, V> start, F2<V, ? super X, V> fold) {
        return base.groupFold(by, start, fold);
    }

    @Override
    public <K, V> ITupleChain<K,V> groupFold(F<? super X, K> by, V start, F2<V, ? super X, V> fold) {
        return base.groupFold(by, start, fold);
    }

    @Override
    public <K, V> ITupleChain<K, List<V>> group(F<? super X, K> by, F<? super X, V> value) {
        return base.group(by, value);
    }

    @Override
    public <K> ITupleChain<K, List<X>> group(F<? super X, K> by) {
        return base.group(by);
    }

    @Override
    public <A, B> ITupleChain<A, B> tuple() {
        return base.tuple();
    }

    @Override
    public IChain<X> append(X... items) {
        return base.append(items);
    }

    @Override
    public IChain<X> prepend(X... items) {
        return base.prepend(items);
    }

    @Override
    public IChain<X> append(Iterable<? extends X> items) {
        return base.append(items);
    }

    public IChain<X> prepend(Iterable<? extends X> items) {
        return base.prepend(items);
    }

    @Override
    public <Y> IChain<Y> cast() {
        return base.cast();
    }

    @Override
    public IChain<X> sort() {
        return base.sort();
    }

    @Override
    public IChain<X> sort(SortDirection dir) {
        return base.sort(dir);
    }

    @Override
    public IChain<X> sort(Comparator<? super X> comparator) {
        return base.sort(comparator);
    }

    @Override
    public ISortBuilder<X> order() {
        return base.order();
    }

    @Override
    public <Y> ITupleChain<X, Y> cross(Iterable<Y> items) {
        return base.cross(items);
    }

    @Override
    public <K, V> ITupleChain<X, Tuple<K, V>> cross(Map<K, V> map) {
        return base.cross(map);
    }

    @Override
    public Iterator<X> iterator() {
        return base.iterator();
    }
}
