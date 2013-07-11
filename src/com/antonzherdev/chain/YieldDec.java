package com.antonzherdev.chain;

public abstract class YieldDec<A, B> extends Yield<A> {
    protected final Yield<B> yield;

    protected YieldDec(Yield<B> yield) {
        this.yield = yield;
    }

    @Override
    public YieldResult start() {
        return yield.start();
    }

    @Override
    public YieldResult end(YieldResult result) {
        return yield.end(result);
    }
}
