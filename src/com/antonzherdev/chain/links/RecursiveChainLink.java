package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class RecursiveChainLink<X> implements ChainLink<X, X> {
    private F<X, Iterable<X>> f;

    public RecursiveChainLink(F<X, Iterable<X>> f) {
        this.f = f;
    }

    @Override
    public Yield<X> buildYield(Yield<X> yield) {
        return new YieldDec<X, X>(yield) {
            @Override
            public YieldResult yield(X item) {
                for (X i : f.f(item)) {
                    if(i == null) continue;
                    if(yield.yield(i) == YieldResult.Break) return YieldResult.Break;
                    if(yield(i) == YieldResult.Break) return YieldResult.Break;
                }
                return YieldResult.Continue;
            }
        };
    }
}
