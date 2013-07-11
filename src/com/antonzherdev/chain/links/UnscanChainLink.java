package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class UnscanChainLink<A, B> implements ChainLink<A, B> {
    private final F2<A, A, B> f;

    public UnscanChainLink(F2<A, A, B> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<B> yield) {
        return new YieldDec<A, B>(yield) {
            A prev;

            @Override
            public YieldResult yield(A item) {
                if(prev != null) {
                    if(yield.yield(f.f(prev, item)) == YieldResult.Break) {
                        prev = null;
                        return YieldResult.Break;
                    } else {
                        prev = item;
                    }
                } else {
                    prev = item;
                }
                return YieldResult.Continue;
            }
        };
    }
}
