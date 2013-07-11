package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Option;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RightJoinItChainLink<A, B> implements ChainLink<Tuple<A, B>, Tuple<A, Option<B>>> {
    private final Set<A> set;

    public RightJoinItChainLink(Iterable<A> it) {
        if (it instanceof Collection){
            set = new HashSet<A>((Collection<? extends A>) it);
        } else {
            set = new HashSet<A>();
            for (A i : it) {
                set.add(i);
            }
        }
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, Option<B>>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, Option<B>>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                if(!set.contains(item._1)) return YieldResult.Continue;
                set.remove(item._1);
                return yield.yield(new Tuple<A, Option<B>>(item._1, Option.opt(item._2)));
            }

            @Override
            public YieldResult end(YieldResult result) {
                for (A key : set) {
                    result = yield.yield(new Tuple<A, Option<B>>(key, Option.<B>none()));
                    if(result == YieldResult.Break) break;
                }

                return super.end(result);
            }
        };
    }
}
