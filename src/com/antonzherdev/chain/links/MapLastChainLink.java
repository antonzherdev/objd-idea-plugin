package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class MapLastChainLink<X> implements ChainLink<X, X> {
    private final F<? super X, ? extends X> f;

    public MapLastChainLink(F<? super X, ? extends X> f) {
        this.f = f;
    }

    @Override
    public Yield<X> buildYield(Yield<X> yield) {
        return new YieldDec<X, X>(yield) {
            X last;
            @Override
            public YieldResult yield(X item) {
                if(last == null) {
                    last = item;
                } else {
                    if(yield.yield(last) == YieldResult.Break) return YieldResult.Break;
                    last = item;
                }
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
                if(result != YieldResult.Break && last != null) {
                    X v = f.f(last);
                    if(v != null) {
                        result = yield.yield(v);
                    }
                }
                return super.end(result);
            }
        };
    }
}
