package com.antonzherdev.chain.links;

import com.antonzherdev.chain.CompareUtils;
import com.antonzherdev.chain.SortDirection;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class SortChainLink<A> implements ChainLink<A, A> {
    final Comparator<A> comparator;

    public SortChainLink(final Comparator<? super A> comparator) {
        this.comparator = new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                int ret = comparator.compare(o1, o2);
                return ret == 0 ? 1 : ret;
            }
        };
    }

    public SortChainLink(SortDirection sortDirection) {
        this.comparator = sortDirection == SortDirection.ASC ? new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                int ret = CompareUtils.compare(o1, o2);
                return ret == 0 ? 1 : ret;
            }
        } : new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                int ret = CompareUtils.compare(o2, o1);
                return ret == 0 ? -1 : ret;
            }
        };
    }

    @Override
    public Yield<A> buildYield(final Yield<A> yield) {
        return new Yield<A>() {
            final TreeSet<A> set = new TreeSet<A>(comparator);

            @Override
            public YieldResult yield(A item) {
                set.add(item);
                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
                return yield.yieldAll(set);
            }
        };
    }
}
