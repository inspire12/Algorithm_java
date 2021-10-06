package com.inspire12.algorithm.demo.thinking_contest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionPath {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = 5; // 이웃집 갯수
        int M = 6; // 양방향 도로
        int X = 21;
        int Y = 1;
        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            String inputLine = scanner.nextLine();
            graph.addEdge(inputLine.split(" "));
            graph.addReverseEdge(inputLine.split(" "));
        }

        int result = graph.findPathByDijkstra(Y, X);
        // 집끼리 연결이 안되어있는 경우 확인
        //
        System.out.println(result);
    }

    private static class Graph {
        List<List<Edge<Integer, Integer>>> adjacentGraph = new ArrayList<>();
        PriorityQueue<Edge<Integer, Integer>> pq = new PriorityQueue();
        List<Integer> minDistTo = new ArrayList<>();

        int todayWalk = 0;

        public Graph(int n) {
            for (int i = 0; i <= n; i++) {
                minDistTo.add(Integer.MAX_VALUE);
                List<Edge<Integer, Integer>> array = new ArrayList<>();
                array.add(new Edge<>(0, 0));
                adjacentGraph.add(array);
            }
        }

        // 0 은 제외함
        public void addEdge(String[] input) {
            adjacentGraph.get(Integer.parseInt(input[0]))
                    .add(new Edge(Integer.parseInt(input[1]), Integer.parseInt(input[2]) * 2));
        }

        public void addReverseEdge(String[] input) {
            adjacentGraph.get(Integer.parseInt(input[1]))
                    .add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[2]) * 2));
        }


        public int findPathByDijkstra(int start, int limitWalk) {
            minDistTo.set(start, 0);
            pq.add(new Edge<>(start, 0));

            while (pq.isEmpty() == false) {
                Edge<Integer, Integer> curEdge = pq.poll();
                int cur = curEdge.getDest();
                int curCost = -curEdge.getWeight();
                for (int i = 1; i <= adjacentGraph.get(cur).size() - 1; i++) {
                    int next = adjacentGraph.get(cur).get(i).getDest();
                    int nextCost = adjacentGraph.get(cur).get(i).getWeight();
                    if (curCost + nextCost < minDistTo.get(next)) {
                        minDistTo.set(next, curCost + nextCost);
                        pq.add(new Edge<>(next, -minDistTo.get(next)));
                    }
                }
            }
            minDistTo.set(0, -1);
            minDistTo.sort(Integer::compareTo);

            int dayWalk = 0;
            int day = 1;
            for (int i = 1; i < minDistTo.size(); i++) {
                if (dayWalk + minDistTo.get(i) > limitWalk) {
                    day += 1;
                    dayWalk = minDistTo.get(i);
                } else {
                    dayWalk += minDistTo.get(i);
                }
            }

            return day;
        }

        public boolean isAllConnected() {
            return true;
        }

    }

    private static class Edge<V, W> implements Comparable<Edge<V, W>> {
        private V dest;
        private W weight;

        public V getDest() {
            return dest;
        }

        public W getWeight() {
            return weight;
        }

        public Edge(V dest, W weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge<V, W> o) {
            return (int) this.getWeight() - (int) o.weight;
        }
    }
}
