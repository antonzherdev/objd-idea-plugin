package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RightJoinDefChainLink<A, B, C> implements ChainLink<Tuple<A, B>, Tuple<A, Tuple<B, C>>> {
    private final Map<A, C> map;
    private final B def;

    public RightJoinDefChainLink(Map<A, C> map, B def) {
        this.map = map;
        this.def = def;
    }


    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Tuple<B, C>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Tuple<B, C>>>(yield) {
            private final Set<A> keys = new HashSet<A>(map.keySet());
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                keys.remove(item._1);
                if(map.containsKey(item._1)) {
                    return yield.yield(Tuple.tuple(item._1, Tuple.tuple(item._2, map.get(item._1))));
                } else {
                    return YieldResult.Continue;
                }
            }

            @Override
            public YieldResult end(YieldResult result) {
                for (A key : keys) {
                    result = yield.yield(Tuple.tuple(key, Tuple.tuple(def, map.get(key))));
                    if(result == YieldResult.Break) break;
                }

                return super.end(result);
            }
        };
    }
}
