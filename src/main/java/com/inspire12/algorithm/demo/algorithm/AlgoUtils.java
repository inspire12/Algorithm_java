package com.inspire12.algorithm.demo.algorithm;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class AlgoUtils {

    static boolean chMin(IntUnaryOperator setter, int cur) {         // setter.accept(newVal) 역할
        int v = setter.applyAsInt(0);                                 // 현재값 꺼내기
        if (cur < v) { setter.applyAsInt(cur); return true; }
        return false;
    }
    static boolean chMax(IntUnaryOperator setter, int cur) {
        int v = setter.applyAsInt(0);
        if (cur > v) { setter.applyAsInt(cur); return true; }
        return false;
    }

    static int upperBound(int[] a, int key) {   // key 초과 첫 인덱스 반환
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= key) l = m + 1;
            else r = m;
        }
        return l;
    }



    static final class DSU {
        int[] p, sz;
        DSU(int n) { p = IntStream.range(0, n).toArray(); sz = new int[n]; Arrays.fill(sz, 1); }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean unite(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
            p[b] = a; sz[a] += sz[b]; return true;
        }
    }


    static long[] dijkstra(List<int[]>[] g, int src) {        // g[u]={ {v,cost}, … }
        long[] dist = new long[g.length];
        Arrays.fill(dist, Long.MAX_VALUE / 4);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        pq.add(new long[]{0, src}); dist[src] = 0;
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0]; int v = (int) cur[1];
            if (d != dist[v]) continue;
            for (int[] e : g[v]) {
                int to = e[0], w = e[1];
                if (dist[to] > d + w) {
                    dist[to] = d + w;
                    pq.add(new long[]{dist[to], to});
                }
            }
        }
        return dist;
    }

    static final class SegMaxTree {
        int n; int[] t;
        SegMaxTree(int[] arr) {
            n = 1; while (n < arr.length) n <<= 1;
            t = new int[2 * n];
            System.arraycopy(arr, 0, t, n, arr.length);
            for (int i = n - 1; i > 0; --i) t[i] = Math.max(t[i << 1], t[i << 1 | 1]);
        }
        void set(int idx, int val) {               // 점 변경
            for (int i = idx + n; (t[i] = val) > 0; i >>= 1) t[i >> 1] = Math.max(t[i], t[i ^ 1]);
        }
        int query(int l, int r) {                  // [l,r]
            int res = Integer.MIN_VALUE;
            for (l += n, r += n + 1; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res = Math.max(res, t[l++]);
                if ((r & 1) == 1) res = Math.max(res, t[--r]);
            }
            return res;
        }
    }

}
