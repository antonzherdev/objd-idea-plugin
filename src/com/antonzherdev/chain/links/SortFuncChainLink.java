package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.SortDirection;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings("unchecked")
public class SortFuncChainLink<A, C extends Comparable<C>> implements ChainLink<A, A> {
    private final F<? super A, C> f;
    private final SortDirection sortDirection;

    public SortFuncChainLink(F<? super A, C> f, SortDirection sortDirection) {
        this.f = f;
        this.sortDirection = sortDirection;
    }

    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        return new Yield<A>() {
            final TreeMap<C, A> map = new TreeMap<C, A>(sortDirection == SortDirection.ASC ? new Comparator<C>() {
                @Override
                public int compare(C o1, C o2) {
                    if(o1 == null) return 1;
                    if(o2 == null) return -1;
                    int ret = o1.compareTo(o2);
                    return ret == 0 ? 1 : ret;
                }
            } : new Comparator<C>() {
                @Override
                public int compare(C o1, C o2) {
                    if(o1 == null) return -1;
                    if(o2 == null) return 1;
                    int ret = o2.compareTo(o1);
                    return ret == 0 ? -1 : ret;
                }
            });

            @Override
            public YieldResult yield(A item) {
                map.put(f.f(item), item);
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
                return yield.yieldAll(map.values());
            }
        };
    }
}
