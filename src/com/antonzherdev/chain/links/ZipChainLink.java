package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Iterator;

public class ZipChainLink<A, B> implements ChainLink<A, Tuple<A, B>> {
    private final Iterable<B> collection;

    public ZipChainLink(Iterable<B> collection) {
        this.collection = collection;
    }

    @Override
    public Yield<A> buildYield(Yield<Tuple<A, B>> yield) {
        final Iterator<B> iterator = collection.iterator();
        return new YieldDec<A, Tuple<A, B>>(yield) {
            @Override
            public YieldResult yield(A item) {
                return yield.yield(new Tuple<A, B>(item, iterator.next()));
            }
        };
    }
}
