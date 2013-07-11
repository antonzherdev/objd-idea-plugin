package com.antonzherdev.chain;

import com.antonzherdev.chain.links.*;

import java.math.BigDecimal;
import java.util.*;

@SuppressWarnings({"Convert2Diamond", "unchecked"})
public class Chain<X> implements IChain<X> {
    Chain() {
    }

    public static <A> IChain<A> chain(Iterable<? extends A> source) {
        return new Chain<Void>().link(new SourceChainLink<A>(source));
    }

    public static <A, B> ITupleChain<A, B> tupleChain(Iterable<Tuple<A, B>> source) {
        return new TupleChain<A, B>((Chain) chain(source));
    }

    public static <A> IChain<A> unionChain(Iterable<? extends A> source, Iterable<? extends A> append) {
        return new Chain<Void>().link(new SourceChainLink<A>(source)).append(append);
    }

    public static <A> IChain<A> chain(A... source) {
        return new Chain<Void>().link(new SourceChainLink<A>(Arrays.asList(source)));
    }

    public static <A, B> ITupleChain<A, B> tupleChain(Tuple<A, B>... source) {
        Chain<Void> chain = new Chain<Void>();
        chain.link(new SourceChainLink<Tuple<A, B>>(Arrays.asList(source)));
        return new TupleChain<A, B>((Chain)chain);
    }

    public static <A, B> ITupleChain<A, B> chain(Map<A, B> source) {
        Chain<Void> chain = new Chain<Void>();
        return chain.tupleLink(new SourceMapChainLink(source));
    }

    @SuppressWarnings("UnusedParameters")
    public static <A> IChain<A> chain(Class<A> cls, Iterable<? extends A> source) {
        return new Chain<Void>().link(new SourceChainLink<A>(source));
    }

    @SuppressWarnings("UnusedParameters")
    public static <A, A1 extends A> IChain<A> chain(Class<A> cls, A1... source) {
        return new Chain<Void>().link(new SourceChainLink<A>(Arrays.asList(source)));
    }

    ChainItem<Object, ?> first;
    ChainItem<?, X> last;

    @Override
    public <C> IChain<C> map(F<? super X, C> f) {
        return link(new MapChainLink<X, C>(f));
    }

    @Override
    public <C> IChain<C> flatMap(F<? super X, ? extends Iterable<C>> f) {
        return link(new FlatMapChainLink<X, C>(f));
    }

    @Override
    public <R> IChain<R> flat() {
        return link((ChainLink<X,R>) new FlatChainLink<R, Iterable<R>>());
    }

    @Override
    public IChain<X> mapFirst(F<? super X, X> f) {
        return link(new MapFirstChainLink<X>(f));
    }

    @Override
    public IChain<X> mapLast(F<? super X, X> f) {
        return link(new MapLastChainLink<X>(f));
    }

    @Override
    public <R> IChain<R> scan(R start, F2<R, X, R> f) {
        return link(new ScanChainLink<X, R>(start, f));
    }

    @Override
    public <R> IChain<R> unscan(F2<X, X, R> f) {
        return link(new UnscanChainLink(f));
    }

    @Override
    public IChain<X> unscan(Class<X> cls) {
        return link(new UnscanChainLink<X, X>(getDeltaF(cls)));
    }

    @Override
    public IChain<X> scan(Class<X> cls) {
        Tuple<X, F2<X, X, X>> s = getSumF(cls);
        return link(new ScanChainLink<X, X>(s._1, s._2));
    }

    @Override
    public IChain<X> filter(F<? super X, Boolean> f) {
        return link(new FilterChainLink<X>(f));
    }

    @Override
    public IChain<X> exclude(Iterable<? extends X> items) {
        return link(new ExcludeChainLink<X>(items));
    }

    @Override
    public IChain<X> reverse() {
        return link(new ReverseChainLink<X>());
    }

    @Override
    public IChain<X> reverseIf(boolean b) {
        if(b) return reverse();
        return this;
    }

    @Override
    public IChain<X> window(int start, int count) {
        return link(new WindowChainLink<X>(start, count));
    }

    @Override
    public <C> ITupleChain<X,C> zip(Iterable<C> collection) {
        return tupleLink(new ZipChainLink<X, C>(collection));
    }

    @Override
    public ITupleChain<X, Integer> zipWithIndex() {
        return tupleLink(new ZipWithIndexChainLink<X>());
    }

    @Override
    public <Y> ITupleChain<Y, X> zip_1(F<? super X, Y> f) {
        return tupleLink(new Zip1ChainLink<X, Y>(f));
    }

    @Override
    public <C> ITupleChain<X, C> zip_2(F<? super X, C> f) {
        return tupleLink(new Zip2ChainLink<X, C>(f));
    }

    @Override
    public <K, V> ITupleChain<K, V> groupFold(F<? super X, K> by, F<? super X, V> start, F2<V, ? super X, V> fold) {
        return tupleLink(new GroupChainLink<X, K, V>(by, start, fold, false));
    }

    @Override
    public <K, V> ITupleChain<K, V> groupFold(F<? super X, K> by, final V start, F2<V, ? super X, V> fold) {
        return tupleLink(new GroupChainLink<X, K, V>(by, new F<X, V>() {
            @Override
            public V f(X x) {
                return start;
            }
        }, fold, false));
    }

    @Override
    public <K, V> ITupleChain<K, List<V>> group(F<? super X, K> by, final F<? super X, V> value) {
        return tupleLink(new GroupChainLink<X, K, List<V>>(by,
                new F<X, List<V>>() {
                    @Override
                    public List<V> f(X x) {
                        return new ArrayList<V>();
                    }
                },
                new F2<List<V>, X, List<V>>() {
                    @Override
                    public List<V> f(List<V> vs, X x) {
                        vs.add(value.f(x));
                        return vs;
                    }
                },
                true
        ));
    }

    @Override
    public <K> ITupleChain<K, List<X>> group(F<? super X, K> by) {
        return tupleLink(new GroupChainLink<X, K, List<X>>(by,
                new F<X, List<X>>() {
                    @Override
                    public List<X> f(X x) {
                        return new ArrayList<X>();
                    }
                },
                new F2<List<X>, X, List<X>>() {
                    @Override
                    public List<X> f(List<X> vs, X x) {
                        vs.add(x);
                        return vs;
                    }
                },
                true
        ));
    }

    @Override
    public <A, B> ITupleChain<A, B> tuple() {
        return new TupleChain<A, B>((Chain<Tuple<A,B>>) this);
    }

    public <C> IChain<C> link(ChainLink<X, C> lnk) {
        if(first == null) {
            first = new ChainItem(lnk);
            last = (ChainItem<?, X>) first;
        } else {
            last.next = new ChainItem(lnk);
            last = (ChainItem<?, X>) last.next;
        }
        return (IChain<C>) this;
    }

    private <K, V> ITupleChain<K,V> tupleLink(ChainLink<X, Tuple<K, V>> lnk) {
        if(first == null) {
            first = new ChainItem(lnk);
            last = (ChainItem<?, X>) first;
        } else {
            last.next = new ChainItem(lnk);
            last = (ChainItem<?, X>) last.next;
        }
        return new TupleChain<K,V>((Chain) this);
    }

    private <R extends Collection<X>> R apply(ApplyYield<X, R> yield) {
        first.getYield(yield).apply();
        return yield.getRet();
    }

    private void apply(Yield<X> yield) {
        first.getYield(yield).apply();
    }

    @Override
    public Iterator<X> iterator() {
        return new Iterator<X>() {
            Lazy<Iterator<X>> i = new Lazy<Iterator<X>>() {
                @Override
                protected Iterator<X> create() throws Exception {
                    return list().iterator();
                }
            };
            @Override
            public boolean hasNext() {
                return i.get().hasNext();
            }

            @Override
            public X next() {
                return i.get().next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static abstract class ApplyYield<B, R extends Collection<B>> extends Yield<B> {
        private final F0<R> newF;
        private R ret;

        public ApplyYield(F0<R> newF) {
            this.newF = newF;
        }

        R getRet() {
            if(ret == null) ret = newF.f();
            return ret;
        }

        @Override
        public YieldResult yield(B item) {
            if(ret == null) ret = newF.f();
            ret.add(item);
            return YieldResult.Continue;
        }

        @Override
        public YieldResult yieldAll(Iterable<? extends B> collection) {
            if(isInstanceOfRet(collection)) {
                ret = (R) collection;
                return YieldResult.Continue;
            } else {
                return super.yieldAll(collection);
            }
        }

        abstract boolean isInstanceOfRet(Iterable<? extends B> collection);
    }

    @Override
    public List<X> list() {
        return apply(new ApplyYield<X, ArrayList<X>>((F0)ARRAY_LIST) {
            @Override
            boolean isInstanceOfRet(Iterable<? extends X> collection) {
                return collection instanceof List;
            }
        });
    }

    @Override
    public Set<X> set() {
        return apply(new ApplyYield<X, HashSet<X>>((F0)HASH_SET) {
            @Override
            boolean isInstanceOfRet(Iterable<? extends X> collection) {
                return collection instanceof Set;
            }
        });
    }

    private static final F0<ArrayList> ARRAY_LIST = new F0<ArrayList>() {
        @Override
        public ArrayList f() {
            return new ArrayList();
        }
    };

    private static final F0<HashSet> HASH_SET = new F0<HashSet>() {
        @Override
        public HashSet f() {
            return new HashSet();
        }
    };

    @Override
    public Option<X> first() {
        final MutableOption<X> ret = new MutableOption<X>();
        first.getYield(new Yield<X>() {
            @Override
            public YieldResult yield(X item) {
                ret.set(item);
                return YieldResult.Break;
            }
        }).apply();
        return ret;
    }

    @Override
    public Option<X> lazyFirstNotNull() {
        return new LazyOption<X>(new F0<Option<X>>() {
            @Override
            public Option<X> f() {
                return firstNotNull();
            }
        });
    }

    @Override
    public Option<X> firstNotNull() {
        final MutableOption<X> ret = new MutableOption<X>();
        first.getYield(new Yield<X>() {
            @Override
            public YieldResult yield(X item) {
                if(item == null) return YieldResult.Continue;
                ret.set(item);
                return YieldResult.Break;
            }
        }).apply();
        return ret;
    }

    @Override
    public Option<X> find(final F<? super X, Boolean> f) {
        final MutableOption<X> ret = new MutableOption<X>();
        first.getYield(new Yield<X>() {
            @Override
            public YieldResult yield(X item) {
                if(f.f(item)) {
                    ret.set(item);
                    return YieldResult.Break;
                }
                return YieldResult.Continue;
            }
        }).apply();
        return ret;
    }

    @Override
    public <R> R fold(R start, F2<R, X, R> f) {
        FoldYield<X, R> yield = new FoldYield<X, R>(start, f);
        first.getYield(yield).apply();
        return yield.value;
    }

    @Override
    public void foreach(final Yield<X> p) {
        first.getYield(p).apply();
    }

    @Override
    public void foreach(final P<X> p) {
        foreach(new Yield<X>() {
            @Override
            public YieldResult yield(X item) {
                p.p(item);
                return YieldResult.Continue;
            }
        });
    }

    @Override
    public X sum(Class<X> cls) {
        Tuple<X, F2<X, X, X>> t = getSumF(cls);
        return fold(t._1, t._2);
    }

    static <X> Tuple<X, F2<X, X, X>> getSumF(Class<X> cls) {
        X start;
        F2<X, X, X> f;
        if(Double.class == cls) {
            start = (X) new Double(0);
            f = (F2<X, X, X>) new F2<Double, Double, Double>() {
                @Override
                public Double f(Double r, Double x) {
                    return r + x;
                }
            };
        } else if(BigDecimal.class == cls) {
            start = (X) new BigDecimal(0);
            f = (F2<X, X, X>) new F2<BigDecimal, BigDecimal, BigDecimal>() {
                @Override
                public BigDecimal f(BigDecimal r, BigDecimal x) {
                    return r.add(x);
                }
            };
        } else if(Integer.class == cls) {
            start = (X) new Integer(0);
            f = (F2<X, X, X>) new F2<Integer, Integer, Integer>() {
                @Override
                public Integer f(Integer r, Integer x) {
                    return r + x;
                }
            };
        } else if(Long.class == cls) {
            start = (X) new Long(0);
            f = (F2<X, X, X>) new F2<Long, Long, Long>() {
                @Override
                public Long f(Long r, Long x) {
                    return r + x;
                }
            };
        }else {
            throw new IllegalArgumentException("Unsupported class " + cls);
        }
        return Tuple.tuple(start, f);
    }

    static <X> F2<X, X, X> getDeltaF(Class<X> cls) {
            F2<X, X, X> f;
            if(Double.class == cls) {
                f = (F2<X, X, X>) new F2<Double, Double, Double>() {
                    @Override
                    public Double f(Double a, Double b) {
                        return b - a;
                    }
                };
            } else if(BigDecimal.class == cls) {
                f = (F2<X, X, X>) new F2<BigDecimal, BigDecimal, BigDecimal>() {
                    @Override
                    public BigDecimal f(BigDecimal a, BigDecimal b) {
                        return b.subtract(a);
                    }
                };
            } else if(Integer.class == cls) {
                f = (F2<X, X, X>) new F2<Integer, Integer, Integer>() {
                    @Override
                    public Integer f(Integer a, Integer b) {
                        return b - a;
                    }
                };
            } else if(Long.class == cls) {
                f = (F2<X, X, X>) new F2<Long, Long, Long>() {
                    @Override
                    public Long f(Long a, Long b) {
                        return b - a;
                    }
                };
            }else {
                throw new IllegalArgumentException("Unsupported class " + cls);
            }
            return f;
        }

    @Override
    public <R extends Number> R sum(Class<R> cls, F<X, R> f) {
        return map(f).sum(cls);
    }

    @Override
    public String getString(final String delimiter) {
        final StringBuilder b = new StringBuilder();
        first.getYield(new Yield<X>() {
            boolean first = true;
            @Override
            public YieldResult yield(X item) {
                if(first) {
                    first = false;
                } else {
                    b.append(delimiter);
                }
                b.append(item);
                return YieldResult.Continue;
            }
        }).apply();
        return b.toString();
    }

    @Override
    public Tuple<Iterable<X>, Iterable<X>> span(final F<X, Boolean> f) {
        final List<X> l1 = new ArrayList<X>();
        final List<X> l2 = new ArrayList<X>();
        apply(new Yield<X>() {
            @Override
            public YieldResult yield(X item) {
                if(f.f(item)) {
                    l2.add(item);
                } else {
                    l1.add(item);
                }
                return YieldResult.Continue;
            }
        });
        return Tuple.<Iterable<X>, Iterable<X>>tuple(l1, l2);
    }

    @Override
    public Option<X> min() {
        MaxYield<X> yield = new MaxYield<X>(new Comparator<X>() {
            @Override
            public int compare(X o1, X o2) {
                return ((Comparable<X>) o2).compareTo(o1);
            }
        });
        apply(yield);
        return Option.opt(yield.ret);
    }

    @Override
    public Option<X> max() {
        MaxYield<X> yield = new MaxYield<X>(new Comparator<X>() {
            @Override
            public int compare(X o1, X o2) {
                return ((Comparable<X>) o1).compareTo(o2);
            }
        });
        apply(yield);
        return Option.opt(yield.ret);
    }

    private static class MaxYield<X> extends Yield<X> {
        private X ret = null;

        private final Comparator<X> comparator;

        private MaxYield(Comparator<X> comparator) {
            this.comparator = comparator;
        }
        @Override
        public YieldResult yield(X item) {
            if(ret == null) {
                ret = item;
            } else {
                if(comparator.compare(ret, item) < 0) {
                    ret = item;
                }
            }
            return YieldResult.Continue;
        }

    }

    @Override
    public IChain<X> append(X... items) {
        return append(Arrays.asList(items));
    }

    @Override
    public IChain<X> prepend(X... items) {
        return prepend(Arrays.asList(items));
    }

    @Override
    public IChain<X> append(Iterable<? extends X> items) {
        return link(new AppendChainLink<X>(items));
    }

    @Override
    public IChain<X> prepend(Iterable<? extends X> items) {
        return link(new PrependChainLink<X>(items));
    }

    @Override
    public <Y> IChain<Y> cast() {
        return (IChain<Y>) this;
    }

    @Override
    public IChain<X> sort() {
        return link(new SortChainLink<X>(SortDirection.ASC));
    }

    @Override
    public IChain<X> sort(SortDirection dir) {
        return link(new SortChainLink<X>(dir));
    }

    @Override
    public IChain<X> sort(Comparator<? super X> comparator) {
        return link(new SortChainLink<X>(comparator));
    }

    @Override
    public ISortBuilder<X> order() {
        return new SortBuilder<X>(this);
    }

    @Override
    public <Y> ITupleChain<X, Y> cross(Iterable<Y> items) {
        return tupleLink(new CrossChainLink<X, Y>(items));
    }

    @Override
    public <K, V> ITupleChain<X, Tuple<K, V>> cross(Map<K, V> map) {
        return cross(new MapIterable(map));
    }

    private class FoldYield<B, R> extends Yield<B> {
        R value;
        final F2<R, B, R> f;

        private FoldYield(R value, F2<R, B, R> f) {
            this.value = value;
            this.f = f;
        }

        @Override
        public YieldResult yield(B item) {
            value = f.f(value, item);
            return YieldResult.Continue;
        }
    }
}