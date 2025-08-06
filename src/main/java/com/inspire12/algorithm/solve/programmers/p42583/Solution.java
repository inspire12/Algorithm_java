package com.inspire12.algorithm.solve.programmers.p42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class TruckMeta {
        int time;
        int order;
        public TruckMeta(int time, int order) {
            this.time = time;
            this.order = order;
        }

        public int getTime() {
            return this.time;
        }

        public int getOrder() {
            return this.order;
        }
    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int nowBridgeWeight = truck_weights[0];
        Queue<TruckMeta> truckOnBridge = new LinkedList<>();
        int nextIndex = 0;
        truckOnBridge.add(new TruckMeta(0, 0));
        nextIndex++;
        for (int time = 1; nowBridgeWeight != 0; time++) {
            printLog(time, truckOnBridge, nextIndex, nowBridgeWeight);

            TruckMeta truck = truckOnBridge.peek();
            if (time - truck.getTime() >= bridge_length) {
                nowBridgeWeight -= truck_weights[truck.getOrder()];
                truckOnBridge.poll();
            }

            if (nextIndex < truck_weights.length && (weight > nowBridgeWeight + truck_weights[nextIndex])) {
                nowBridgeWeight += truck_weights[nextIndex];
                truckOnBridge.add(new TruckMeta(time, nextIndex));
                nextIndex++;
            }
            if (truckOnBridge.isEmpty()){
                return time + 1;
            }
        }
        return 0;
    }

    private void printLog(int time, Queue<TruckMeta> truckOnBridge, int nextIndex, int nowBridgeWeight) {
        StringBuilder truckMetaStr = new StringBuilder();
        for(TruckMeta truckMeta: truckOnBridge) {
            truckMetaStr.append(truckMeta.getTime()).append(truckMeta.getOrder()).append(" ");
        }
        System.out.println(String.format("time: %s %s %d %d", String.valueOf(time), truckMetaStr.toString(), nextIndex, nowBridgeWeight));
    }
}
