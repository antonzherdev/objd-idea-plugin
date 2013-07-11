package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class FilterChainLink<A> implements ChainLink<A, A> {
    private final F<? super A, Boolean> f;

    public FilterChainLink(F<? super A, Boolean> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<A> yield) {
        return new YieldDec<A, A>(yield) {
            @Override
            public YieldResult yield(A item) {
                if(!f.f(item)) return YieldResult.Continue;

                return yield.yield(item);
            }
        };
    }
}
