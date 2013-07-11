package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class MapFirstChainLink<X> implements ChainLink<X, X> {
    private final F<? super X, ? extends X> f;

    public MapFirstChainLink(F<? super X, ? extends X> f) {
        this.f = f;
    }

    @Override
    public Yield<X> buildYield(Yield<X> yield) {
        return new YieldDec<X, X>(yield) {
            boolean first = true;
            @Override
            public YieldResult yield(X item) {
                if(first) {
                    first = false;
                    X v = f.f(item);
                    if(v == null) return YieldResult.Continue;
                    return yield.yield(v);
                } else {
                    return yield.yield(item);
                }
            }
        };
    }
}
