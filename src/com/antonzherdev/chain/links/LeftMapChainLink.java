package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class LeftMapChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<C, B>> {
    private final F<? super A, ? extends C> f;

    public LeftMapChainLink(F<? super A, ? extends C> f) {
        this.f = f;
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<C, B>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<C, B>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                return yield.yield(new Tuple<C, B>(f.f(item._1), item._2));
            }
        };
    }
}
