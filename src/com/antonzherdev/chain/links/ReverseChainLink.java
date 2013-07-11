package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.LinkedList;

public class ReverseChainLink<A> implements ChainLink<A, A> {
    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        final LinkedList<A> ret = new LinkedList<A>();
        return new Yield<A>() {
            @Override
            public YieldResult yield(A item) {
                ret.addFirst(item);
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
                return yield.yieldAll(ret);
            }
        };
    }
}
