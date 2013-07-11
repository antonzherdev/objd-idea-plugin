package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Scan1ChainLink<X, B> implements ChainLink<Tuple<X, B>, Tuple<X, B>> {
    private final F2<X, X, X> f;

    public Scan1ChainLink(F2<X, X, X> f) {
        this.f = f;
    }

    @Override
    public Yield<Tuple<X, B>> buildYield(Yield<Tuple<X, B>> yield) {
        return new YieldDec<Tuple<X, B>, Tuple<X, B>>(yield) {
            X value = null;

            @Override
            public YieldResult yield(Tuple<X, B> item) {
                if(value == null) {
                    value = item._1;
                } else {
                    value = f.f(value, item._1);
                }
                return yield.yield(Tuple.tuple(value, item._2));
            }
        };
    }
}
