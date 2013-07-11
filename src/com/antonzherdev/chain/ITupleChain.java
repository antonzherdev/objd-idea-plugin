package com.antonzherdev.chain;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Option;
import com.antonzherdev.chain.Tuple;

import java.util.List;
import java.util.Map;

public interface ITupleChain<A, B> extends IChain<Tuple<A, B>> {
/*************************************************************************************************
 * Result
 *************************************************************************************************/
    Map<A, B> getMap();

    Tuple<List<A>, List<B>> unzip();

/*************************************************************************************************
 * Left - Right
 *************************************************************************************************/
    /**
     * [A, B] -> [f(A), B]
     */
    <C> ITupleChain<C, B> map_1(F<A, C> f);

    /**
     * [A, B] -> [A, f(B)]
     */
    <C> ITupleChain<A, C> map_2(F<B, C> f);

    ITupleChain<A, B> scan_1(F2<A, A, A> f);

    ITupleChain<A, B> scan_1(Class<A> cls);

    ITupleChain<A, B> scan_2(F2<B, B, B> f);

    ITupleChain<A, B> scan_2(Class<B> cls);

/*************************************************************************************************
 * Join
 *************************************************************************************************/
    /**
     * [(A, B)] join [(A, C)] = [(B, C)] with same A
     */
    <C> ITupleChain<A, Tuple<B, C>> join(Map<A, C> map);

    /**
     * [(A, B)] join [A] = [(A, B)] where A contains in [A]
     */
    ITupleChain<A, B> join(Iterable<A> keys);

    /**
     * [(A, B)] join [(A, C)] = [(B, C?)] with same A
     */
    <C> ITupleChain<A, Tuple<B, Option<C>>> leftJoin(Map<A, C> map);

    <C> ITupleChain<A, Tuple<B, C>> leftJoin(Map<A, C> map, C def);

    /**
     * [(A, B)] join [(A, C)] = [(B?, C)] with same A
     */
    <C> ITupleChain<A, Tuple<Option<B>, C>> rightJoin(Map<A, C> map);

    <C> ITupleChain<A, Tuple<B, C>> rightJoin(Map<A, C> map, B def);

    /**
     *  [(A, B)] join [A] =
     *      [(A, some(B))] where A in [A] and A in [(A, B)]
     *      [(A, none)] where A in [A]
     */
    ITupleChain<A, Option<B>> rightJoin(Iterable<A> keys);

    /**
     * [(A, B)] join [(A, C)] = [(B?, C)] with same A
     */
    <C> ITupleChain<A, Tuple<Option<B>, Option<C>>> fullJoin(Map<A, C> map);

    <C> ITupleChain<A, Tuple<B, C>> fullJoin(Map<A, C> map, B defB, C defC);

    /**
     *  [(A, B)] join [A] =
     *      [(A, some(B))] where A in [(A, B)]
     *      [(A, none)] where A in [A]
     */
    ITupleChain<A, Option<B>> fullJoin(Iterable<A> keys);

/*************************************************************************************************
 * Unzip
 *************************************************************************************************/
    IChain<A> unzip_1();

    IChain<B> unzip_2();
}
