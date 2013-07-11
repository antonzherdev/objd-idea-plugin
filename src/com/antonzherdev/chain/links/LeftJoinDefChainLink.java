package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Map;

public class LeftJoinDefChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<B, C>>> {
    private final Map<A, C> map;
    private final C def;

    public LeftJoinDefChainLink(Map<A, C> map, C def) {
        this.map = map;
        this.def = def;
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<B, C>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<B, C>>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                C v = map == null ? null : map.get(item._1);
                return yield.yield(new Tuple<A, Tuple<B, C>>(item._1, Tuple.<B, C>tuple(item._2,  v == null ? def : v)));
            }
        };
    }
}
