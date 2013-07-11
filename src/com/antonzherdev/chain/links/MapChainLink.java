package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class MapChainLink<A, B> implements ChainLink<A, B> {
    private final F<? super A, ? extends B> f;

    public MapChainLink(F<? super A, ? extends B> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<B> yield) {
        return new YieldDec<A, B>(yield) {
            @Override
            public YieldResult yield(A item) {
                B v = f.f(item);
                if(v == null) return YieldResult.Continue;
                return yield.yield(v);
            }
        };
    }
}
