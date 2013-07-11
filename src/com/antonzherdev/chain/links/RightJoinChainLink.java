package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Option;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RightJoinChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<Option<B>, C>>> {
    private final Map<A, C> map;

    public RightJoinChainLink(Map<A, C> map) {
        this.map = map;
    }


    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<Option<B>, C>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<Option<B>, C>>>(yield) {
            private final Set<A> keys = new HashSet<A>(map.keySet());
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                keys.remove(item._1);
                if(map.containsKey(item._1)) {
                    return yield.yield(Tuple.tuple(item._1, Tuple.tuple(Option.some(item._2), map.get(item._1))));
                } else {
                    return YieldResult.Continue;
                }
            }

            @Override
            public YieldResult end(YieldResult result) {
                for (A key : keys) {
                    result = yield.yield(Tuple.tuple(key, Tuple.tuple(Option.<B>none(), map.get(key))));
                    if(result == YieldResult.Break) break;
                }

                return super.end(result);
            }
        };
    }
}
