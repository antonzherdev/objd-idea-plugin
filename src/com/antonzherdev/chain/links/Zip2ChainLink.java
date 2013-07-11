package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Zip2ChainLink<A, B> implements ChainLink<A, Tuple<A, B>> {
    private final F<? super A, B> f;

    public Zip2ChainLink(F<? super A, B> f) {
        this.f = f;
    }

    @Override
    public Yield<A> buildYield(Yield<Tuple<A, B>> yield) {
        return new YieldDec<A,Tuple<A, B>>(yield) {
            @Override
            public YieldResult yield(A item) {
                return yield.yield(new Tuple<A, B>(item, f.f(item)));
            }
        };
    }
}
