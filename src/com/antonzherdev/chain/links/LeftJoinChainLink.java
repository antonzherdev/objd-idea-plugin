package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Option;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Map;

public class LeftJoinChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<B, Option<C>>>> {
    private final Map<A, C> map;

    public LeftJoinChainLink(Map<A, C> map) {
        this.map = map;
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<B, Option<C>>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<B, Option<C>>>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                return yield.yield(new Tuple<A, Tuple<B, Option<C>>>(item._1, Tuple.tuple(item._2,  Option.opt(map.get(item._1)))));
            }
        };
    }
}
