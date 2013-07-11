package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class RightMapChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, C>> {
    private final F<? super B, ? extends C> f;

    public RightMapChainLink(F<? super B, ? extends C> f) {
        this.f = f;
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, C>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, C>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                return yield.yield(new Tuple<A, C>(item._1, f.f(item._2)));
            }
        };
    }
}
