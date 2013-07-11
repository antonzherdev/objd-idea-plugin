package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.Map;

public class SourceMapChainLink<A, B> implements ChainLink<Void, Tuple<A, B>> {
    private final Map<? extends A, ? extends B> map;

    public SourceMapChainLink(Map<? extends A, ? extends B> map) {
        this.map = map;
    }


    @Override
    public Yield<Void> buildYield(final Yield< Tuple<A, B>> yield) {
        return new Yield<Void>() {
            @Override
            public YieldResult yield(Void item) {
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
               return yield.yieldAll(map);
            }
        };
    }
}
