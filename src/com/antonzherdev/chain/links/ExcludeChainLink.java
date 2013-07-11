package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

import java.util.Collection;
import java.util.HashSet;

public class ExcludeChainLink<A> implements ChainLink<A, A> {
    private final Collection<A> items;

    @SuppressWarnings("unchecked")
    public ExcludeChainLink(Iterable<? extends A> items) {
        if(items instanceof Collection) {
            this.items = (Collection<A>) items;
        } else {
            this.items = new HashSet<A>();
            for (A item : items) {
                this.items.add(item);
            }
        }
    }

    @Override
    public Yield<A> buildYield(Yield<A> yield) {
        return new YieldDec<A, A>(yield) {
            @Override
            public YieldResult yield(A item) {
                if(items.contains(item)) return YieldResult.Continue;

                return yield.yield(item);
            }
        };
    }
}
