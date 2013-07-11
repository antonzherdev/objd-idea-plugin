package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class CrossChainLink<A, B> implements ChainLink<A, Tuple<A, B>> {
    private final Iterable<B> collection;

    public CrossChainLink(Iterable<B> collection) {
        this.collection = collection;
    }

    @Override
    public Yield<A> buildYield(Yield<Tuple<A, B>> yield) {
        return new YieldDec<A, Tuple<A, B>>(yield) {
            @Override
            public YieldResult yield(A item) {
                for (B b : collection) {
                    if(yield.yield(Tuple.tuple(item, b)) == YieldResult.Break) return YieldResult.Break;
                }

                return YieldResult.Continue;
            }
        };
    }
}
