package com.antonzherdev.chain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public interface IChain<X> extends Iterable<X> {
/*************************************************************************************************
 * Map
 *************************************************************************************************/
    /**
     * f(X) -> R<br/>
     * X[] -> R[]
     */
    <R> IChain<R> map(F<? super X, R> f);

    /**
     * f(X) -> R[]<br/>
     * X[] -> R[]
     */
    <R> IChain<R> flatMap(F<? super X, ? extends Iterable<R>> f);


    /**
     * [[R]] -> [R]
     */
    <R> IChain<R> flat();

    IChain<X> mapFirst(F<? super X, X> f);

    IChain<X> mapLast(F<? super X, X> f);

/*************************************************************************************************
 * Scan
 *************************************************************************************************/

    /**
     * Кумулятивная сумма
     */
    <R> IChain<R> scan(R start, F2<R, X, R> f);

    /**
     * Кумулятивная сумма
     */
    IChain<X> scan(Class<X> cls);

    /**
     * [f(x1, x2), f(x2, x3), ...]
     */
    <R> IChain<R> unscan(F2<X, X, R> f);

    /**
     * [x2 - x1, x3 - x2, ...]
     */
    IChain<X> unscan(Class<X> cls);

/*************************************************************************************************
 * Filter
 *************************************************************************************************/
    /**
     * f(X) = boolean<br/>
     * X[] -> X[] if f(X)
     */
    IChain<X> filter(F<? super X, Boolean> f);

    IChain<X> exclude(Iterable<? extends X> items);

    /**
     * X[] -> X[] if start <= i && i < start + count
     */
    IChain<X> window(int start, int count);

/*************************************************************************************************
 * Zip
 *************************************************************************************************/
    /**
     * X[] -> (X, Y) where xi = yi
     */
    <Y> ITupleChain<X, Y> zip(Iterable<Y> collection);

    /**
     * X[] -> (X, i)
     */
    ITupleChain<X,Integer> zipWithIndex();

    /**
     * f(X) -> Y<br/>
     * X[] -> (f(X), X)[]
     */
    <Y> ITupleChain<Y, X> zip_1(F<? super X, Y> f);

    /**
     * f(X) -> Y<br/>
     * X[] -> (X, f(X))[]
     */
    <Y> ITupleChain<X, Y> zip_2(F<? super X, Y> f);

/*************************************************************************************************
 * Group
 *************************************************************************************************/
    /**
     * by(X) -> K<br/>
     * start(X) -> V<br/>
     * fold(V, X) -> V<br/>
     * <br/>
     * X[] -> (K, V)[]<br/>
     *  where V = fold(fold(start(X), X), X1..) where by(X) == by(X1) == by(X2) == ...<br/>
     *  where K = by(K)
     */
    <K, V> ITupleChain<K, V> groupFold(F<? super X, K> by, F<? super X, V> start, F2<V, ? super X, V> fold);

    /**
     * by(X) -> K<br/>
     * fold(V, X) -> V<br/>
     * <br/>
     * X[] -> (K, V)[]<br/>
     *  where V = fold(fold(start, X), X1..) where by(X) == by(X1) == by(X2) == ...<br/>
     *  where K = by(K)
     */
    <K, V> ITupleChain<K, V> groupFold(F<? super X, K> by, V start, F2<V, ? super X, V> fold);

    /**
     * by(X) -> K<br/>
     * f(X) -> V<br/>
     * <br/>
     * X[] -> (K, V[])[]<br/>
     *  where V = [f(X), f(X2), ...] where by(X) == by(X1) == by(X2) == ... <br/>
     *  where K = by(K)
     */
    <K, V> ITupleChain<K, List<V>> group(F<? super X, K> by, F<? super X, V> value);

    /**
     * by(X) -> K<br/>
     * <br/>
     * X[] -> (K, X[])[]<br/>
     *  where X[] = [X, X1, X2, ...] where by(X) == by(X1) == by(X2) == ...
     */
    <K> ITupleChain<K, List<X>> group(F<? super X, K> by);

    <A, B> ITupleChain<A, B> tuple();

/*************************************************************************************************
 * Append
 *************************************************************************************************/
    /**
     * X[] -> X[] || items[]
     */
    IChain<X> append(X... items);

    /**
     * X[] -> items[] || X[]
     */
    IChain<X> prepend(X... items);

    /**
     * X[] -> X[] || items[]
     */
    IChain<X> append(Iterable<? extends X> items);

    /**
     * X[] -> items[] || X[]
     */
    IChain<X> prepend(Iterable<? extends X> items);

    <Y> IChain<Y> cast();

/*************************************************************************************************
 * Sort
 *************************************************************************************************/
    /**
     * X[] -> X[]<br/>
     *  where X[n - 1] = X[0], X[n - 2] = X[1], ...
     */
    IChain<X> reverse();

    /**
     * X[] -> X[]<br/>
     *  where if b => X[n - 1] = X[0], X[n - 2] = X[1], ...
     *        else X[0] = X[0],...
     */
    IChain<X> reverseIf(boolean b);

    /**
     * X[] -> X[]<br/>
     *  where X[1] <= X[2] <= ...
     */
    IChain<X> sort();

    /**
     * X[] -> X[]<br/>
     *  if dir == ASC then X[1] <= X[2] <= ... <br/>
     *  if dir == DESC then X[1] >= X[2] >= ...
     */
    IChain<X> sort(SortDirection dir);

    /**
     * X[] -> X[] order by comparator
     */
    IChain<X> sort(Comparator<? super X> comparator);

    ISortBuilder<X> order();

/*************************************************************************************************
 * Join
 *************************************************************************************************/
    <Y> ITupleChain<X, Y> cross(Iterable<Y> items);

    <K, V> ITupleChain<X, Tuple<K, V>> cross(Map<K, V> map);
/*************************************************************************************************
 * Result
 *************************************************************************************************/
    /**
     * X[] -> List[X]
     */
    List<X> list();

    /**
     * X[] -> Set[X]
     */
    Set<X> set();

    /**
     * X[] -><br/>
     *  if empty none<br/>
     *  else some(X[0])
     */
    Option<X> first();

    Option<X> lazyFirstNotNull();

    /**
     * X[] -> filter(X[] where X[i] != null).first()
     */
    Option<X> firstNotNull();

    /**
     * f(X) -> boolean<br/>
     * X[] -> filter(X[] where f(X[i)).first()
     */
    Option<X> find(F<? super X, Boolean> f);

    /**
     * f(R, X) -> R<br/>
     * X[] -> f(f(f(start, X), X1) ...)
     */
    <R> R fold(R start, F2<R, X, R> f);

    void foreach(Yield<X> p);

    void foreach(P<X> p);

    X sum(Class<X> cls);

    <R extends Number> R sum(Class<R> cls, F<X, R> f);

    String getString(String delimiter);

    Tuple<Iterable<X>, Iterable<X>> span(F<X, Boolean> f);

    Option<X> min();

    Option<X> max();
}
