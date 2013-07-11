package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Option;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.antonzherdev.chain.Tuple.tuple;

public class FullJoinChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<Option<B>, Option<C>>>> {
    private final Map<A, C> map;

    public FullJoinChainLink(Map<A, C> map) {
        this.map = map;
    }


    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<Option<B>, Option<C>>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<Option<B>, Option<C>>>>(yield) {
            private final Set<A> keys = new HashSet<A>(map.keySet());
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                keys.remove(item._1);
                return yield.yield(tuple(item._1, tuple(Option.some(item._2), Option.opt(map.get(item._1)))));
            }

            @Override
            public YieldResult end(YieldResult result) {
                for (A key : keys) {
                    result = yield.yield(tuple(key, tuple(Option.<B>none(), Option.some(map.get(key)))));
                    if(result == YieldResult.Break) break;
                }

                return super.end(result);
            }
        };
    }
}
