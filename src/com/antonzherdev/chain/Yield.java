package com.antonzherdev.chain;

import com.antonzherdev.chain.Tuple;

import java.util.Map;

public abstract class Yield<A> {
    public abstract YieldResult yield(A item);

    public YieldResult start() {return YieldResult.Continue;}
    public YieldResult end(YieldResult result) { return result;}

    public YieldResult yieldAll(Iterable<? extends A> collection) {
        YieldResult brk = start();
        if(brk == YieldResult.Continue) {
            for (A item : collection) {
                if(item == null) continue;
                if(yield(item) == YieldResult.Break) {
                    brk = YieldResult.Break;
                    break;
                }
            }
        }
        return end(brk);
    }

    @SuppressWarnings("unchecked")
    public YieldResult yieldAll(Map<?, ?> map) {
        YieldResult brk = start();
        if(brk == YieldResult.Continue) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if(yield((A) new Tuple(entry.getKey(), entry.getValue())) == YieldResult.Break) {
                    brk = YieldResult.Break;
                    break;
                }
            }
        }
        return end(brk);
    }

    public void apply() {
        end(start());
    }
}
