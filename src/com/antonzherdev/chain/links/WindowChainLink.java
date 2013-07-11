package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldDec;
import com.antonzherdev.chain.YieldResult;

public class WindowChainLink<A> implements ChainLink<A, A> {
    final int start;
    final int end;

    public WindowChainLink(int start, int count) {
        this.start = start;
        this.end = start + count;
    }

    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        return new YieldDec<A, A>(yield) {
            int i = -1;
            @Override
            public YieldResult yield(A item) {
                i++;
                if(i < start) return YieldResult.Continue;
                if(i >= end) return YieldResult.Break;

                return yield.yield(item);
            }
        };
    }
}
