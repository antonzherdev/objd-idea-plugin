package com.antonzherdev.chain;

import com.antonzherdev.chain.links.ChainLink;

public class ChainItem<A, B> {
    private final ChainLink<A, B> operation;
    ChainItem<B, ?> next;

    public ChainItem(ChainLink<A, B> operation) {
        this.operation = operation;
    }


    @SuppressWarnings("unchecked")
    public Yield<A> getYield(Yield<?> yield) {
        return operation.buildYield(next == null ? (Yield<B>) yield : next.getYield(yield));
    }
}
