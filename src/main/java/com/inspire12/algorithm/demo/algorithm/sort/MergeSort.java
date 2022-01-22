package com.inspire12.algorithm.demo.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> list) {

        return mergeSort(list, 0);
    }

    public List<Integer> mergeSort(List<Integer> array, int depth) {
        int size = array.size();
        if (array.size() > 1) {
            System.out.println(depth + " " + array.toString());
            List<Integer> frontList = mergeSort(array.subList(0, size / 2 ), depth + 1);
            List<Integer> backList = mergeSort(array.subList(size / 2, size), depth + 1);
            return merge(frontList, backList);
        }

        return array;
    }

    public List<Integer> merge(List<Integer> frontArray, List<Integer> backArray) {
        List<Integer> result = new ArrayList<>();
        int frontIndex = 0;
        int backIndex = 0;
        while (frontIndex < frontArray.size() && backIndex < backArray.size()) {
            if (frontArray.get(frontIndex) < backArray.get(backIndex)) {
                result.add(frontArray.get(frontIndex));
                frontIndex++;
            } else {
                result.add(backArray.get(backIndex));
                backIndex++;
            }
        }
        if (frontIndex < backIndex) {
            for (int i = frontIndex; i < frontArray.size(); i++) {
                result.add(frontArray.get(i));
            }
        } else {
            for (int i = backIndex; i < backArray.size(); i++) {
                result.add(backArray.get(i));
            }
        }
        System.out.println("depth: " + frontArray.size() + " " + backArray.size() );
        return result;
    }
}
