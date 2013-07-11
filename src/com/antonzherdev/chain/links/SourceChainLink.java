package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.Arrays;

public class SourceChainLink<A> implements ChainLink<Void, A> {
    private final Iterable<? extends A> collection;

    public SourceChainLink(Iterable<? extends A> collection) {
        this.collection = collection == null ? Arrays.<A>asList() : collection;
    }


    @Override
    public Yield<Void> buildYield(final Yield<A> yield) {
        return new Yield<Void>() {
            @Override
            public YieldResult yield(Void item) {
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
               return yield.yieldAll(collection);
            }
        };
    }
}
