package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class AppendChainLink<A> implements ChainLink<A, A> {
    private final Iterable<? extends A> collection;

    public AppendChainLink(Iterable<? extends A> collection) {
        this.collection = collection;
    }

    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        return new YieldDec<A, A>(yield) {
            @Override
            public YieldResult start() {
                return super.start();
            }

            @Override
            public YieldResult yield(A item) {
                return yield.yield(item);
            }

            @Override
            public YieldResult end(YieldResult result) {
                if(result == YieldResult.Continue) {
                    for (A item : collection) {
                        if(item == null) continue;

                        if(yield.yield(item) == YieldResult.Break) {
                            result = YieldResult.Break;
                            break;
                        }
                    }
                }
                return super.end(result);
            }
        };
    }
}
