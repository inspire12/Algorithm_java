package com.inspire12.algorithm.demo.beakjoon.p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferedReader.readLine();
        int nodeSize = Integer.parseInt(line);
        List<List<Edge>> map = new ArrayList<>();
        for (int i = 0; i <= nodeSize; i++) {
            map.add(new ArrayList<>());
        }
        line = bufferedReader.readLine();
        int edgeSize = Integer.parseInt(line);


        while (edgeSize-- > 0) {
            line = bufferedReader.readLine();
            if (line.isBlank()) {
                break;
            }
            String[] inputs = line.split(" ");

            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            List<Edge> list = map.get(from);
            list.add(new Edge(from, to, weight));
        }
        line = bufferedReader.readLine();
        String[] inputs = line.split(" ");

        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        System.out.println(dijkstra(map, nodeSize, start, end));
    }

    public static int dijkstra(List<List<Edge>> graph, int size, int start, int end) {
        int maxCost = 100_000;
        List<Integer> dist = new ArrayList<>();
        List<Boolean> visit = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            dist.add(maxCost);
            visit.add(Boolean.FALSE);
        }

        dist.set(start, 0);
        visit.set(start, Boolean.TRUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.cost > dist.get(curNode.node)) {
                continue;
            }
            for (Edge edge : graph.get(curNode.node)) {
                if (dist.get(edge.to) >= dist.get(edge.from) + edge.weight) {
                    dist.set(edge.to, dist.get(edge.from) + edge.weight);
                    pq.add(new Node(edge.to, dist.get(edge.to) ));
                }
            }
        }
        return dist.get(end);
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
}
