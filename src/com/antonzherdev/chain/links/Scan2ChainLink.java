package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Scan2ChainLink<A, X> implements ChainLink<Tuple<A, X>, Tuple<A, X>> {
    private final F2<X, X, X> f;

    public Scan2ChainLink(F2<X, X, X> f) {
        this.f = f;
    }

    @Override
    public Yield<Tuple<A, X>> buildYield(Yield<Tuple<A, X>> yield) {
        return new YieldDec<Tuple<A, X>, Tuple<A, X>>(yield) {
            X value = null;

            @Override
            public YieldResult yield(Tuple<A, X> item) {
                if(value == null) {
                    value = item._2;
                } else {
                    value = f.f(value, item._2);
                }
                return yield.yield(Tuple.tuple(item._1, value));
            }
        };
    }
}
