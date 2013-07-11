package com.antonzherdev.chain.links;

import com.antonzherdev.chain.Yield;

public interface ChainLink<A, B> {
    Yield<A> buildYield(Yield<B> yield);
}
