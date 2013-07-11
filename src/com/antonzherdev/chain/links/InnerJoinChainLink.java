package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Map;

import static com.antonzherdev.chain.Tuple.tuple;

public class InnerJoinChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<B, C>>> {
    private final Map<A, C> map;

    public InnerJoinChainLink(Map<A, C> map) {
        this.map = map;
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<B, C>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<B, C>>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                if(map.containsKey(item._1)) {
                    return yield.yield(new Tuple<A, Tuple<B, C>>(item._1, tuple(item._2, map.get(item._1))));
                } else {
                    return YieldResult.Continue;
                }
            }
        };
    }
}
