package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.antonzherdev.chain.Tuple.tuple;

public class FullJoinDefChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<B, C>>> {
    private final Map<A, C> map;
    private final B b;
    private final C c;

    public FullJoinDefChainLink(Map<A, C> map, B b, C c) {
        this.map = map;
        this.b = b;
        this.c = c;
    }


    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<B, C>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<B, C>>>(yield) {
            private final Set<A> keys = new HashSet<A>(map.keySet());
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                keys.remove(item._1);
                C v = map.get(item._1);
                return yield.yield(tuple(item._1, tuple(item._2, v == null ? c : v)));
            }

            @Override
            public YieldResult end(YieldResult result) {
                for (A key : keys) {
                    result = yield.yield(tuple(key, tuple(b, map.get(key))));
                    if(result == YieldResult.Break) break;
                }

                return super.end(result);
            }
        };
    }
}
