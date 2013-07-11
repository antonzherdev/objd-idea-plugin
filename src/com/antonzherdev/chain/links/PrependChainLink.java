package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class PrependChainLink<A> implements ChainLink<A, A> {
    private final Iterable<? extends A> collection;

    public PrependChainLink(Iterable<? extends A> collection) {
        this.collection = collection;
    }

    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        return new YieldDec<A, A>(yield) {
            @Override
            public YieldResult start() {
                if(super.start() == YieldResult.Break) return YieldResult.Break;
                for (A item : collection) {
                    if(item == null) continue;
                    if(yield.yield(item) == YieldResult.Break) {
                        return YieldResult.Break;
                    }
                }
                return YieldResult.Continue;
            }

            @Override
            public YieldResult yield(A item) {
                return yield.yield(item);
            }
        };
    }
}
