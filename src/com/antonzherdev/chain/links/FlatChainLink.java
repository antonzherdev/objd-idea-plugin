package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class FlatChainLink<X, C extends Iterable<X>> implements ChainLink<C, X> {
    @Override
    public Yield<C> buildYield(Yield<X> yield) {
        return new YieldDec<C, X>(yield) {
            @Override
            public YieldResult yield(C item) {
                for (X i : item) {
                    if(i == null) continue;
                    if(yield.yield(i) == YieldResult.Break) return YieldResult.Break;
                }
                return YieldResult.Continue;
            }
        };
    }
}
