package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class FlatMapChainLink<A, B> implements ChainLink<A, B> {
    private final F<? super A, ? extends Iterable<? extends B>> f;

    public FlatMapChainLink(F<? super A, ? extends Iterable<? extends B>> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(final Yield<B> yield) {
        return new YieldDec<A, B>(yield) {
            @Override
            public YieldResult yield(A item) {
                for (B i : f.f(item)) {
                    if(i == null) continue;
                    if(yield.yield(i) == YieldResult.Break) return YieldResult.Break;
                }
                return YieldResult.Continue;
            }
        };
    }
}
