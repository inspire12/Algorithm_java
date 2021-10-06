package com.inspire12.algorithm.demo.beakjoon.p1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        int nodeSize = Integer.parseInt(line);

        Map<Integer, List<Edge>> map = new HashMap<>();

        while (null != (line = bufferedReader.readLine())) {
            if (line.isBlank()) {
                break;
            }
            String[] inputs = line.split(" ");

            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            List<Edge> list = map.getOrDefault(from, new ArrayList<>());
            list.add(new Edge(from, to, weight));
            map.put(from, list);
        }
        int maxValue = 0;
        for (int i = 1; i <= nodeSize; i++) {
            int tmp = dijkstra(map, i);
            maxValue = Math.max(tmp, maxValue);
        }
    }

    public static void bfs(Map<Integer, List<Edge>> graph, int start, Runnable runnable) {
        Set<Integer> visits = new HashSet<>();
        Stack<Integer> nextNode = new Stack<>();
        nextNode.add(start);
        while (!nextNode.isEmpty()) {
            int curNode = nextNode.pop();
            List<Edge> nodes = graph.get(curNode);

            runnable.run();

            for (Edge node : nodes) {
                if (!visits.contains(node.from)) {
                    visits.add(node.from);
                    nextNode.add(node.from);
                }
            }
        }
    }

    public static int dijkstra(Map<Integer, List<Edge>> graph, int start) {
        List<Integer> dist = new ArrayList<>();
        List<Boolean> visit = new ArrayList<>();
        int size = graph.size();
        for (int i = 0; i < size; i++) {
            dist.add(0);
            visit.add(Boolean.FALSE);
        }

        dist.set(start, Integer.MAX_VALUE);
        visit.set(start, Boolean.TRUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Edge edge : graph.get(start)) {

                int maxDistance = dist.get(curNode.getNode()) + edge.weight;
                if (maxDistance < dist.get(edge.to) + edge.weight) {
                    maxDistance = dist.get(edge.to) + edge.weight;
                    dist.set(curNode.getNode(), maxDistance);
                    pq.add(new Node(edge.to, maxDistance));
                }
            }
        }
        System.out.println(dist);
        return 0;
    }

    public static class Node implements Comparable<Node>{
        final int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        public int getNode() {
            return node;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost - this.cost;
        }
    }

    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Graph {
        int node[][] = new int[100_003][100_003];
        int visit[];
        Map<Integer, List<Edge>> map;


        void addNode() {

        }
    }
}
