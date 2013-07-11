package com.antonzherdev.chain;

import com.antonzherdev.chain.F;

public interface ISortBuilder<X> {
    <C extends Comparable> ISortBuilder<X> asc(F<? super X, C> f);

    <C extends Comparable> ISortBuilder<X> desc(F<? super X, C> f);

    IChain<X> end();
}
