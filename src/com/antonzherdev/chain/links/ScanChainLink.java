package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class ScanChainLink<A, B> implements ChainLink<A, B> {
    private final B start;
    private final F2<B, A, B> f;

    public ScanChainLink(B start, F2<B, A, B> f) {
        this.start = start;
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<B> yield) {
        return new YieldDec<A, B>(yield) {
            B value = start;

            @Override
            public YieldResult start() {
                if(super.start() == YieldResult.Break) return YieldResult.Break;
                return yield.yield(start);
            }

            @Override
            public YieldResult yield(A item) {
                value = f.f(value, item);
                return yield.yield(value);
            }
        };
    }
}
