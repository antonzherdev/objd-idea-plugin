package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class Unzip2ChainLink<A, B> implements ChainLink<Tuple<A, B>, B> {
    public Unzip2ChainLink() {
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<B> yield) {
        return new YieldDec<Tuple<A, B>, B>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                return yield.yield(item._2);
            }
        };
    }
}
