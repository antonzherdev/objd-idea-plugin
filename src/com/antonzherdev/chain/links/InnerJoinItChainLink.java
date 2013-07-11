package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InnerJoinItChainLink<A, B> implements ChainLink<Tuple<A, B>, Tuple<A, B>> {
    private final Set<A> set;

    public InnerJoinItChainLink(Iterable<A> it) {
        if(it instanceof Set) {
            set = (Set<A>) it;
        } else if (it instanceof Collection){
            set = new HashSet<A>((Collection<? extends A>) it);
        } else {
            set = new HashSet<A>();
            for (A i : it) {
                set.add(i);
            }
        }
    }

    @Override
    public Yield<Tuple<A, B>> buildYield(Yield<Tuple<A, B>> yield) {
        return new YieldDec<Tuple<A, B>, Tuple<A, B>>(yield) {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                if(set.contains(item._1)) {
                    return yield.yield(item);
                } else {
                    return YieldResult.Continue;
                }
            }
        };
    }
}
