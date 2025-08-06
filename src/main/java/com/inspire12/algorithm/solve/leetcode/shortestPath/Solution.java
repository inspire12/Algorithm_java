package com.inspire12.algorithm.solve.leetcode.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int c = findCheapestPrice(3, new int[][]{new int[]{0,1,100}, new int[]{1,2,100}, new int[]{2,0,100}}, 0,2, 0);
        System.out.println(c);
    }

    public static int findCheapestPrice(int nodeCount, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> edges = new ArrayList<>();
        for(int i = 0; i < nodeCount; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int cur = flight[0];
            edges.get(cur).add(flight);
        }

        return dijkstra(nodeCount, edges, src, k) + dijkstra(nodeCount, edges, k, dst);
    }

    private static int dijkstra(int nodeCount, List<List<int[]>> edges, int src, int dst) {
        int[] dist = new int[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));
        pq.add(src);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int curNode = pq.poll();
            List<int[]> nextEdges = edges.get(curNode);

            for(int[] nextEdge : nextEdges) {
                int nextNode = nextEdge[1];
                if (dist[nextNode] >= dist[curNode] + nextEdge[2]) {
                    dist[nextNode] = dist[curNode] + nextEdge[2];
                    pq.add(nextNode);
                }
            }
        }
        return dist[dst];
    }
}