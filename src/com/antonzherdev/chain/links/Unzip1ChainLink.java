package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Unzip1ChainLink<A, B> implements ChainLink<Tuple<A, B>, A> {
    public Unzip1ChainLink() {
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<A> yield) {
        return new YieldDec<Tuple<A, B>, A>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                return yield.yield(item._1);
            }
        };
    }
}
