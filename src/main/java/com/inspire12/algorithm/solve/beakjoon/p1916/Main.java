package com.inspire12.algorithm.solve.beakjoon.p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static List<List<Node>> map;
    static int[] dist;
    static boolean[] check;
    static int maxCost = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int nodeSize = Integer.parseInt(line);

        map = new ArrayList<>();
        for (int i = 0; i <= nodeSize; i++) {
            map.add(new ArrayList<>());
        }
        line = bufferedReader.readLine();
        int edgeSize = Integer.parseInt(line);
        dist = new int[nodeSize + 1];
        check = new boolean[nodeSize + 1];

        Arrays.fill(dist, maxCost);

        while (edgeSize-- > 0) {
            line = bufferedReader.readLine();
            String[] inputs = line.split(" ");

            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);

            map.get(from).add(new Node(to, weight));
        }
        line = bufferedReader.readLine();
        String[] inputs = line.split(" ");

        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        System.out.println(dijkstra(map, nodeSize, start, end));

    }

    public static int dijkstra(List<List<Node>> graph, int size, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[size + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : graph.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }
}
