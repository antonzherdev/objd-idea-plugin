package com.antonzherdev.chain;

import com.antonzherdev.chain.links.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class TupleChain<A, B> extends ChainDelegate<Tuple<A, B>> implements ITupleChain<A, B> {
    TupleChain(Chain<Tuple<A, B>> chain) {
        super(chain);
    }

    @Override
    public Map<A, B> getMap() {
        MapYield<A, B> yield = new MapYield<A, B>();
        base.getYield(yield).apply();
        return yield.getRet();
    }

    @Override
    public Tuple<List<A>, List<B>> unzip() {
        final List<A> a = new ArrayList<A>();
        final List<B> b = new ArrayList<B>();
        base.getYield(new Yield<Tuple<A, B>>() {
            @Override
            public YieldResult yield(Tuple<A, B> item) {
                a.add(item._1);
                b.add(item._2);
                return YieldResult.Continue;
            }
        }).apply();
        return new Tuple<List<A>, List<B>>(a, b);
    }

    @Override
    public <C> ITupleChain<C, B> map_1(F<A, C> f) {
        return link(new LeftMapChainLink<A, B, C>(f));
    }

    @Override
    public <C> ITupleChain<A, C> map_2(F<B, C> f) {
        return link(new RightMapChainLink<A, B, C>(f));
    }

    @Override
    public ITupleChain<A, B> scan_1(F2<A, A, A> f) {
        return link(new Scan1ChainLink<A, B>(f));
    }

    @Override
    public ITupleChain<A, B> scan_1(Class<A> cls) {
        return scan_1(Chain.getSumF(cls)._2);
    }

    @Override
    public ITupleChain<A, B> scan_2(F2<B, B, B> f) {
        return link(new Scan2ChainLink<A, B>(f));
    }

    @Override
    public ITupleChain<A, B> scan_2(Class<B> cls) {
        return scan_2(Chain.getSumF(cls)._2);
    }

    @Override
    public <C> ITupleChain<A, Tuple<B, C>> join(Map<A, C> map) {
        return link(new InnerJoinChainLink(map));
    }

    @Override
    public ITupleChain<A, B> join(Iterable<A> keys) {
        return link(new InnerJoinItChainLink(keys));
    }

    @Override
    public <C> ITupleChain<A, Tuple<B, Option<C>>> leftJoin(Map<A, C> map) {
        return link(new LeftJoinChainLink<A, B, C>(map));
    }

    @Override
    public <C> ITupleChain<A, Tuple<B, C>> leftJoin(Map<A, C> map, C def) {
        return link(new LeftJoinDefChainLink<A, B, C>(map, def));
    }

    @Override
    public <C> ITupleChain<A, Tuple<Option<B>, C>> rightJoin(Map<A, C> map) {
        return link(new RightJoinChainLink<A, B, C>(map));
    }

    @Override
    public <C> ITupleChain<A, Tuple<B, C>> rightJoin(Map<A, C> map, B def) {
        return link(new RightJoinDefChainLink<A, B, C>(map, def));
    }

    @Override
    public ITupleChain<A, Option<B>> rightJoin(Iterable<A> keys) {
        return link(new RightJoinItChainLink<A, B>(keys));
    }

    @Override
    public ITupleChain<A, Option<B>> fullJoin(Iterable<A> keys) {
        return link(new FullJoinItChainLink<A, B>(keys));
    }

    @Override
    public IChain<A> unzip_1() {
        return base.link(new Unzip1ChainLink<A, B>());
    }

    @Override
    public IChain<B> unzip_2() {
        return base.link(new Unzip2ChainLink<A, B>());
    }

    @Override
    public <C> ITupleChain<A, Tuple<Option<B>, Option<C>>> fullJoin(Map<A, C> map) {
        return link(new FullJoinChainLink<A, B, C>(map));
    }

    @Override
    public <C> ITupleChain<A, Tuple<B, C>> fullJoin(Map<A, C> map, B defB, C defC) {
        return link(new FullJoinDefChainLink<A, B, C>(map, defB, defC));
    }

    public <C, D> ITupleChain<C, D> link(ChainLink<Tuple<A, B>, Tuple<C, D>> lnk) {
        return new TupleChain<C, D>((Chain<Tuple<C,D>>) base.link(lnk));
    }

    private static class MapYield<A, B> extends Yield<Tuple<A, B>> {
        private Map<A, B> ret;

        public MapYield() {
        }

        @Override
        public YieldResult yield(Tuple<A, B> item) {
            if(ret == null) ret = new HashMap<A, B>();
            ret.put(item._1, item._2);
            return YieldResult.Continue;
        }

        public Map<A, B> getRet() {
            if(ret == null) ret = new HashMap<A, B>();
            return ret;
        }

        @SuppressWarnings("unchecked")
        @Override
        public YieldResult yieldAll(Map<?, ?> map) {
            ret = (Map<A, B>) map;
            return YieldResult.Continue;
        }
    }
}
