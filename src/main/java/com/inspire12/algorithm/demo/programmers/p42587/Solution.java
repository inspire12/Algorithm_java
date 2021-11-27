package com.inspire12.algorithm.demo.programmers.p42587;

import java.util.*;

public class Solution {
    public static class Document {
        int priority;
        int location;

        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return this.priority;
        }

        public int getLocation() {
            return this.location;
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<Document>();
        int maxValue = 0;
        int index = 0;
        PriorityQueue<Integer> prioritiesOrder = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int priority : priorities) {
            queue.add(new Document(priority, index));
            prioritiesOrder.add(priority);
            index++;
        }
        int max = prioritiesOrder.poll();

        int printCount = 0;
        while(!queue.isEmpty()) {

            Document doc = queue.poll();
            if (max > doc.getPriority()) {
                queue.add(doc);

            } else {
                printCount++;
                if (doc.getLocation() == location) {
                    return printCount;
                }
                max = prioritiesOrder.poll();
            }
        }

        return 0;
//        PriorityQueue<Document> pq = new PriorityQueue<>(Comparator.comparingInt(Document::getPriority));
//        int index = 0;
//        for (int priority : priorities) {
//            pq.add(new Document(priority, index));
//            index++;
//        }
//        int a = 0;
//        for (Document doc : pq) {
//            if (doc.getLocation() == location) {
//                return a;
//            }
//            a++;
//        }
//        return priorities.length;
    }
}
