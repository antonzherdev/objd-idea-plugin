package com.antonzherdev.chain;

import com.antonzherdev.chain.links.SortChainLink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unchecked")
public class SortBuilder<X> implements ISortBuilder<X> {
    final Chain<X> chain;

    public SortBuilder(Chain<X> chain) {
        this.chain = chain;
    }

    private final List<Tuple<F<? super X, ?>, SortDirection>> fs = new ArrayList<Tuple<F<? super X, ?>, SortDirection>>();

    @Override
    public <C extends Comparable> ISortBuilder<X> asc(F<? super X, C> f) {
        fs.add((Tuple)Tuple.tuple(f, SortDirection.ASC));
        return this;
    }

    @Override
    public <C extends Comparable> ISortBuilder<X> desc(F<? super X, C> f) {
        fs.add((Tuple)Tuple.tuple(f, SortDirection.DESC));
        return this;
    }

    @Override
    public IChain<X> end() {
        return chain.link(new SortChainLink<X>(new Comparator<X>() {
            @Override
            public int compare(X o1, X o2) {
                if(o1 == o2) return 0;
                if(o1 == null) return 1;
                if(o2 == null) return -1;
                for (Tuple<F<? super X, ?>, SortDirection> f : fs) {
                    Object v1 = f._1.f(o1);
                    Object v2 = f._1.f(o2);

                    int r = CompareUtils.compare(v1, v2);
                    if(r != 0) return f._2 == SortDirection.ASC ? r : -r;
                }

                return 0;
            }
        }));
    }

}
