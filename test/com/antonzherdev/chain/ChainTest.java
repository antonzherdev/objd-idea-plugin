package com.antonzherdev.chain;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.antonzherdev.chain.Chain.chain;
import static com.antonzherdev.chain.Chain.tupleChain;
import static com.antonzherdev.chain.Option.none;
import static com.antonzherdev.chain.Option.some;
import static com.antonzherdev.chain.Tuple.tuple;
import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@SuppressWarnings("unchecked")
public class ChainTest {
    @Test
    public void testMap() throws Exception {
        List<Integer> list = chain(asList(1, 3, 1))
                .map(new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer i) {
                        return i * i;
                    }
                }).list();
        assertEquals(asList(1, 9, 1), list);
    }

    @Test
    public void testChain() throws Exception {
        List<Integer> list = chain(asList(1, 3, 2))
                .map(new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer i) {
                        return i * i;
                    }
                })
                .filter(new B<Integer>() {
                    @Override
                    public Boolean f(Integer i) {
                        return i <= 4;
                    }
                })
                .map(new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer i) {
                        return i - 1;
                    }
                }).list();
        assertEquals(asList(0, 3), list);
    }

    @Test
    public void testFlatMap() throws Exception {
        List<Integer> list = chain(asList(asList(1, 2), asList(3)))
                .flatMap(new F<List<Integer>, Iterable<Integer>>() {
                    @Override
                    public Iterable<Integer> f(List<Integer> integers) {
                        return integers;
                    }
                }).list();
        assertEquals(asList(1, 2, 3), list);
    }

    @Test
    public void testReverse() throws Exception {
        List<Integer> list = chain(asList(1, 2, 3))
                .reverse().list();
        assertEquals(asList(3, 2, 1), list);
        assertEquals(LinkedList.class, list.getClass());
    }

    @Test
    public void testReverseIf() throws Exception {
        List<Integer> list = chain(asList(1, 2, 3))
                .reverseIf(true).list();
        assertEquals(asList(3, 2, 1), list);
        list = chain(asList(1, 2, 3))
                .reverseIf(false).list();
        assertEquals(asList(1, 2, 3), list);
    }

    @Test
    public void testFirst() throws Exception {
        Option<Integer> first = chain(asList(1, 2, 3)).reverse().first();
        assertEquals(some(3), first);
        first = chain(new ArrayList<Integer>()).first();
        assertEquals(Option.<Integer>none(), first);
    }

    @Test
    public void testWindow() throws Exception {
        List<Integer> list = chain(asList(1, 2, 3, 4)).window(1, 2).list();
        assertEquals(asList(2, 3), list);
    }

    @Test
    public void testFind() throws Exception {
        Option<Integer> opt = chain(asList(1, 2, 3)).map(new F<Integer, Integer>() {
            @Override
            public Integer f(Integer a) {
                return a * a;
            }
        }).find(new B<Integer>() {
            @Override
            public Boolean f(Integer i) {
                return i.equals(4);
            }
        });
        assertEquals(some(4), opt);
    }

    @Test
    public void testFold() throws Exception {
        Integer ret = chain(asList(1, 2, 3)).fold(0, new F2<Integer, Integer, Integer>() {
            @Override
            public Integer f(Integer r, Integer i) {
                return r + i;
            }
        });
        assertEquals(6, (int)ret);
    }

    @Test
    public void testFirstNotNull() throws Exception {
        Option<Integer> i = chain(asList(null, null, 2, 1, null)).firstNotNull();
        assertEquals(some(2), i);
        i = chain(asList(null, null, 2, 1, null)).lazyFirstNotNull();
        assertEquals(some(2), i);
    }

    @Test
    public void testZip() throws Exception {
        Tuple<Integer,String> t = chain(asList(1, 2, 3)).zip(asList("1", "2", "3")).first().get();
        assertEquals(new Tuple<Integer, String>(1, "1"), t);
    }

    @Test
    public void testTupleMap() throws Exception {
        Map<Integer,String> m = chain(asList(1, 2, 3)).zip(asList("1", "2", "3")).getMap();
        assertEquals(3, m.size());
        assertEquals("1", m.get(1));
        assertEquals("2", m.get(2));
        assertEquals("3", m.get(3));
    }

    @Test
    public void testZipWithIndex() throws Exception {
        Map<Integer, Integer> m = chain(asList(2, 1)).zipWithIndex().getMap();
        assertEquals(2, m.size());
        assertEquals(0, (int)m.get(2));
        assertEquals(1, (int)m.get(1));
    }

    @Test
    public void testZip_1() throws Exception {
        Map<String, Integer> m = chain(asList(2, 1)).zip_1(new F<Integer, String>() {
            @Override
            public String f(Integer integer) {
                return String.valueOf(integer);
            }
        }).getMap();
        assertEquals(2, m.size());
        assertEquals(1, (int)m.get("1"));
        assertEquals(2, (int)m.get("2"));
    }

    @Test
    public void testZip_2() throws Exception {
        Map<Integer, String> m = chain(asList(2, 1)).zip_2(new F<Integer, String>() {
            @Override
            public String f(Integer integer) {
                return String.valueOf(integer);
            }
        }).getMap();
        assertEquals(2, m.size());
        assertEquals("1", m.get(1));
        assertEquals("2", m.get(2));
    }

    @Test
    public void testUnzip() throws Exception {
        Tuple<List<Integer>, List<Integer>> unzip = chain(asList(2, 1)).zipWithIndex().unzip();
        assertEquals(asList(2, 1), unzip._1);
        assertEquals(asList(0, 1), unzip._2);
    }

    @Test
    public void testGroup1() throws Exception {
        Map<Integer, Integer> map = chain(asList(1, 2, 3, 4)).groupFold(
                new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer item) {
                        return item % 2;
                    }
                }, new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer integer) {
                        return 0;
                    }
                }, new F2<Integer, Integer, Integer>() {
                    @Override
                    public Integer f(Integer a, Integer b) {
                        return a + b;
                    }
                }
        ).getMap();
        assertEquals(2, map.size());
        assertEquals(6, (int)map.get(0));
        assertEquals(4, (int)map.get(1));


    }

    @Test
    public void testGroup2() throws Exception {
        Map<Integer, Integer> map = chain(asList(1, 2, 3, 4)).groupFold(
                new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer item) {
                        return item % 2;
                    }
                }, 0, new F2<Integer, Integer, Integer>() {
                    @Override
                    public Integer f(Integer a, Integer b) {
                        return a + b;
                    }
                }
        ).getMap();
        assertEquals(2, map.size());
        assertEquals(6, (int)map.get(0));
        assertEquals(4, (int)map.get(1));
    }

    @Test
    public void testGroup3() throws Exception {
        Map<Integer, List<Integer>> map = chain(asList(1, 2, 3, 4)).group(
                new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer item) {
                        return item % 2;
                    }
                }, new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer a) {
                        return a*a;
                    }
                }
        ).getMap();
        assertEquals(2, map.size());
        assertEquals(asList(4, 16), map.get(0));
        assertEquals(asList(1, 9), map.get(1));
    }

    @Test
    public void testGroup4() throws Exception {
        Map<Integer, List<Integer>> map = chain(asList(1, 2, 3, 4)).group(
                new F<Integer, Integer>() {
                    @Override
                    public Integer f(Integer item) {
                        return item % 2;
                    }
                }
        ).getMap();
        assertEquals(2, map.size());
        assertEquals(asList(2, 4), map.get(0));
        assertEquals(asList(1, 3), map.get(1));
    }

    @Test
    public void testAppend1() throws Exception {
        List<Integer> list = chain(asList(1, 2)).append(3, 4).list();
        assertEquals(asList(1, 2, 3, 4), list);
    }

    @Test
    public void testAppend2() throws Exception {
        List<Integer> list = chain(asList(1, 2)).append(asList(3, 4)).list();
        assertEquals(asList(1, 2, 3, 4), list);
    }

    @Test
    public void testPrepend1() throws Exception {
        List<Integer> list = chain(asList(1, 2)).prepend(3, 4).list();
        assertEquals(asList(3, 4, 1, 2), list);
    }

    @Test
    public void testPrepend2() throws Exception {
        List<Integer> list = chain(asList(1, 2)).prepend(asList(3, 4)).list();
        assertEquals(asList(3, 4, 1, 2), list);
    }

    @Test
    public void testSort1() throws Exception {
        List<Integer> list = chain(asList(2, 3, 1)).sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).list();
        assertEquals(asList(1, 2, 3), list);
    }

    @Test
    public void testSort2() throws Exception {
        List<Integer> list = chain(asList(2, 3, 1, 3)).sort().list();
        assertEquals(asList(1, 2, 3, 3), list);
        list = chain(asList(2, 3, 1, 3)).sort(SortDirection.DESC).list();
        assertEquals(asList(3, 3, 2, 1), list);
    }

    @Test
    public void testOrder() throws Exception {
        List<Tuple<Integer, Integer>> list = chain(asList(tuple(2, 1), tuple(1, -2), tuple(2, 2))).order()
                    .asc(new F<Tuple<Integer, Integer>, Comparable>() {
                        @Override
                        public Comparable f(Tuple<Integer, Integer> x) {
                            return x._1;
                        }
                    })
                    .desc(new F<Tuple<Integer, Integer>, Comparable>() {
                        @Override
                        public Comparable f(Tuple<Integer, Integer> x) {
                            return x._2;
                        }
                    })
                .end().list();
        assertEquals(asList(tuple(1, -2), tuple(2, 2), tuple(2, 1)), list);
    }

    @Test
    public void testJoin() throws Exception {
        List<Tuple<Integer, Tuple<String, String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .join(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap())
                .list();
        assertEquals(asList(tuple(1, tuple("1", "-1"))), list);
    }

    @Test
    public void testLeftJoin() throws Exception {
        List<Tuple<Integer, Tuple<String, Option<String>>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .leftJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap())
                .list();
        assertEquals(asList(tuple(1, tuple("1", some("-1"))), tuple(2, tuple("2", none()))), list);
    }

    @Test
    public void testLeftJoinDef() throws Exception {
        List<Tuple<Integer, Tuple<String, String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .leftJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap(), "?")
                .list();
        assertEquals(asList(tuple(1, tuple("1", "-1")), tuple(2, tuple("2", "?"))), list);
    }

    @Test
    public void testRightJoin() throws Exception {
        List<Tuple<Integer, Tuple<Option<String>, String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .rightJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap())
                .list();
        assertEquals(asList(tuple(1, tuple(some("1"), "-1")), tuple(3, tuple(none(), "-3"))), list);
    }

    @Test
    public void testRightJoinDef() throws Exception {
        List<Tuple<Integer, Tuple<String, String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .rightJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap(), "?")
                .list();
        assertEquals(asList(tuple(1, tuple("1", "-1")), tuple(3, tuple("?", "-3"))), list);
    }

    @Test
    public void testFullJoin() throws Exception {
        List<Tuple<Integer, Tuple<Option<String>, Option<String>>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .fullJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap())
                .list();
        assertEquals(asList(tuple(1, tuple(some("1"), some("-1"))), tuple(2, tuple(some("2"), none())),
                tuple(3, tuple(none(), some("-3")))), list);
    }

    @Test
    public void testFullJoinDef() throws Exception {
        List<Tuple<Integer, Tuple<String, String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .fullJoin(tupleChain(tuple(1, "-1"), tuple(3, "-3")).getMap(), "?", "!")
                .list();
        assertEquals(asList(tuple(1, tuple("1", "-1")), tuple(2, tuple("2", "!")),
                tuple(3, tuple("?", "-3"))), list);
    }


    @Test
    public void testForeach() throws Exception {
        final AtomicInteger t = new AtomicInteger();
        chain(asList(1, 2, 3, 4)).foreach(new Yield<Integer>() {
            @Override
            public YieldResult yield(Integer item) {
                t.addAndGet(item);
                if (item > 2) return YieldResult.Break;
                return YieldResult.Continue;
            }
        });
        assertEquals(6, t.get());
    }

    @Test
    public void testForeach2() throws Exception {
        final AtomicInteger t = new AtomicInteger();
        chain(asList(1, 2, 3, 4)).foreach(new P<Integer>() {
            @Override
            public void p(Integer x) {
                t.addAndGet(x);
            }
        });
        assertEquals(10, t.get());
    }

    @Test
    public void testLeftMap() throws Exception {
        Tuple<List<Integer>, List<Integer>> unzip = chain(asList(3, 2, 1)).zipWithIndex().map_1(new F<Integer, Integer>() {
            @Override
            public Integer f(Integer x) {
                return x * 2;
            }
        }).unzip();
        assertEquals(asList(6, 4, 2), unzip._1);
        assertEquals(asList(0, 1, 2), unzip._2);
    }

    @Test
    public void testRightMap() throws Exception {
        Tuple<List<Integer>, List<Integer>> unzip = chain(asList(3, 2, 1)).zipWithIndex().map_2(new F<Integer, Integer>() {
            @Override
            public Integer f(Integer x) {
                return x * 2;
            }
        }).unzip();
        assertEquals(asList(3, 2, 1), unzip._1);
        assertEquals(asList(0, 2, 4), unzip._2);
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(8, (int)chain(asList(3, 1, 4)).sum(Integer.class));
        assertEquals(16, (int) chain(asList(3, 1, 4)).sum(Integer.class, new F<Integer, Integer>() {
            @Override
            public Integer f(Integer x) {
                return x*2;
            }
        }));

    }

    @Test
    public void testFlat() throws Exception {
        List<Integer> list = chain(asList(1, 2), asList(), asList(3, 4)).<Integer>flat().list();
        assertEquals(asList(1, 2, 3, 4), list);
    }


    @Test
    public void testJoinIt() throws Exception {
        List<Tuple<Integer, String>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .join(asList(1, 3))
                .list();
        assertEquals(asList(tuple(1, "1")), list);
    }

    @Test
    public void testRightJoinIt() throws Exception {
        List<Tuple<Integer, Option<String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .rightJoin(asList(1, 3))
                .list();
        assertEquals(asList(tuple(1, some("1")), tuple(3, none())), list);
    }

    @Test
    public void testFullJoinIt() throws Exception {
        List<Tuple<Integer, Option<String>>> list = tupleChain(tuple(1, "1"), tuple(2, "2"))
                .fullJoin(asList(1, 3))
                .list();
        assertEquals(asList(tuple(1, some("1")), tuple(2, some("2")), tuple(3, none())), list);
    }

    @Test
    public void testScan() throws Exception {
        List<Integer> list = chain(1, 2, 3)
                .scan(0, new Fold<Integer, Integer>() {
                    @Override
                    public Integer f(Integer r, Integer x) {
                        return r + x;
                    }
                })
                .list();
        assertEquals(asList(0, 1, 3, 6), list);
        list = chain(1, 2, 3)
                .scan(Integer.class)
                .list();
        assertEquals(asList(0, 1, 3, 6), list);
    }

    @Test
    public void testScan1() throws Exception {
        List<Tuple<Integer, Integer>> list = tupleChain(tuple(1, 2), tuple(3, 4))
                .scan_1(new Fold1<Integer>() {
                    @Override
                    public Integer f(Integer r, Integer x) {
                        return r + x;
                    }
                })
                .list();
        assertEquals(asList(tuple(1, 2), tuple(4, 4)), list);
        list = tupleChain(tuple(1, 2), tuple(3, 4))
                        .scan_1(Integer.class)
                        .list();
        assertEquals(asList(tuple(1, 2), tuple(4, 4)), list);
    }

    @Test
    public void testScan2() throws Exception {
        List<Tuple<Integer, Integer>> list = tupleChain(tuple(1, 2), tuple(3, 4))
                .scan_2(new Fold1<Integer>() {
                    @Override
                    public Integer f(Integer r, Integer x) {
                        return r + x;
                    }
                })
                .list();
        assertEquals(asList(tuple(1, 2), tuple(3, 6)), list);
        list = tupleChain(tuple(1, 2), tuple(3, 4))
                .scan_2(Integer.class)
                .list();
        assertEquals(asList(tuple(1, 2), tuple(3, 6)), list);
    }

    @Test
    public void testUnzip1() throws Exception {
        List<Integer> list = chain(tuple(1, "1"), tuple(2, "2")).<Integer, String>tuple()
                .unzip_1().list();
        assertEquals(asList(1, 2), list);
    }

    @Test
    public void testUnzip2() throws Exception {
        List<String> list = chain(tuple(1, "1"), tuple(2, "2")).<Integer, String>tuple()
                .unzip_2().list();
        assertEquals(asList("1", "2"), list);
    }

    @Test
    public void testSpan() throws Exception {
        Tuple<Iterable<Integer>, Iterable<Integer>> r = chain(1, 2, 3).span(new B<Integer>() {
            @Override
            public Boolean f(Integer x) {
                return (x % 2) == 0;
            }
        });
        assertEquals(asList(1, 3), r._1);
        assertEquals(asList(2), r._2);
    }

    @Test
    public void testUnscan() throws Exception {
        List<Integer> list = chain(1, 2, 3).unscan(new F2<Integer, Integer, Integer>() {
            @Override
            public Integer f(Integer a, Integer b) {
                return b - a;
            }
        }).list();
        assertEquals(asList(1, 1), list);
        list = chain(1, 2, 3).unscan(Integer.class).list();
        assertEquals(asList(1, 1), list);
    }

    @Test
    public void testMapFirst() throws Exception {
        List<Integer> list = chain(1, 2, 3).mapFirst(new F<Integer, Integer>() {
            @Override
            public Integer f(Integer x) {
                return x * 2;
            }
        }).list();
        assertEquals(asList(2, 2, 3), list);
    }

    @Test
    public void testMapLast() throws Exception {
        List<Integer> list = chain(1, 2, 3).mapLast(new F<Integer, Integer>() {
            @Override
            public Integer f(Integer x) {
                return x * 2;
            }
        }).list();
        assertEquals(asList(1, 2, 6), list);
    }

    @Test
    public void testFromMap() throws Exception {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "1");
        map.put(2, "2");
        assertTrue(map == chain(map).getMap());
        List<Tuple<Integer, String>> list = chain(map).list();
        assertEquals(asList(tuple(1, "1"), tuple(2, "2")), list);
    }

    @Test
    public void testMin() throws Exception {
        assertEquals(some(1), chain(1, 3, 2).min());
        assertEquals(Option.<Integer>none(), Chain.<Integer>chain().min());
    }

    @Test
    public void testMax() throws Exception {
        assertEquals(some(3), chain(1, 3, 2).max());
        assertEquals(Option.<Integer>none(), Chain.<Integer>chain().max());
    }

    @Test
    public void testGetString() throws Exception {
        assertEquals("1, 3, 1", chain(1, 3, 1).getString(", "));
    }

    @Test
    public void testCross() throws Exception {
        List<Tuple<Integer, Integer>> l = chain(1, 2).cross(asList(3, 4)).list();
        assertEquals(asList(tuple(1, 3), tuple(1, 4), tuple(2, 3), tuple(2, 4)), l);
    }

    @Test
    public void testExclude() throws Exception {
        List<Integer> l = chain(1, 2, 3, 4).exclude(asList(2, 4)).list();
        assertEquals(asList(1, 3), l);
    }
}
