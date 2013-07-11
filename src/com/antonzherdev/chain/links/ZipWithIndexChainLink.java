package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class ZipWithIndexChainLink<A> implements ChainLink<A, Tuple<A, Integer>> {
    @Override
    public Yield<A> buildYield(final Yield<Tuple<A, Integer>> yield) {
        return new YieldDec<A, Tuple<A, Integer>>(yield) {
            int i = -1;
            @Override
            public YieldResult yield(A item) {
                i++;
                return yield.yield(new Tuple<A, Integer>(item, i));
            }
        };
    }
}
