package com.antonzherdev.chain.links;

import com.antonzherdev.chain.F;
import com.antonzherdev.chain.F2;
import com.antonzherdev.chain.Tuple;
import com.antonzherdev.chain.Yield;
import com.antonzherdev.chain.YieldResult;

import java.util.HashMap;
import java.util.Map;

public class GroupChainLink<A, K, V> implements ChainLink<A, Tuple<K, V>> {
    final F<? super A, K> keyF;
    final F<? super A, V> startF;
    final F2<V, ? super A, V> foldF;
    private final boolean mutable;

    public GroupChainLink(F<? super A, K> keyF, F<? super A, V> startF, F2<V, ? super A, V> foldF, boolean mutable) {
        this.keyF = keyF;
        this.startF = startF;
        this.foldF = foldF;
        this.mutable = mutable;
    }

    @Override
    public Yield<A> buildYield(final Yield<Tuple<K, V>> yield) {
        return new Yield<A>() {
            final Map<K, V> ret = new HashMap<K, V>();

            @Override
            public YieldResult yield(A item) {
                K key = keyF.f(item);
                V value = ret.get(key);
                if(value == null && (mutable || !ret.containsKey(key))) {
                    value = startF.f(item);
                    if(mutable) ret.put(key, value);
                }
                value = foldF.f(value, item);
                if(!mutable) ret.put(key, value);

                return YieldResult.Continue;
            }

            @Override
            public YieldResult end(YieldResult result) {
                return yield.yieldAll(ret);
            }
        };
    }
}
