package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Zip1ChainLink<A, B> implements ChainLink<A, Tuple<B, A>> {
    private final F<? super A, B> f;

    public Zip1ChainLink(F<? super A, B> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<Tuple<B, A>> yield) {
        return new YieldDec<A,Tuple<B, A>>(yield) {
            @Override
            public YieldResult yield(A item) {
                return yield.yield(new Tuple<B, A>(f.f(item), item));
            }
        };
    }
}
