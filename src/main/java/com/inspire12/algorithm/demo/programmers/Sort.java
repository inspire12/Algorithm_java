
package com.inspire12.algorithm.demo.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 10, 7, 2, 1, 3, 6, 5, 9, 8);
        sortedArrayByBinary(list);
    }

    static void sortBubble() {
        List<Integer> list = Arrays.asList(4, 10, 7, 2, 1, 3, 6, 5, 9, 8);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (list.get(i) > list.get(j))
                    Collections.swap(list, i, j);
            }
        }
        list.forEach(a -> System.out.print(a + " "));
    }

    static void sortInsertion() {
        List<Integer> list = Arrays.asList(4, 10, 7, 2, 1, 3, 6, 5, 9, 8);
        List<Integer> result = new ArrayList<>();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            insertInSortedArray(list.get(i), result);
        }
        result.forEach(a -> System.out.print(a + " "));
    }

    static void insertInSortedArray(int element, List<Integer> result) {
        for (int i = 0; i < result.size(); i++) {
            if (element < result.get(i)) {
                result.add(i, element);
                return;
            }
        }
        result.add(element);
    }

    static void sortedArrayByBinary(List<Integer> elements) {

        List<Integer> result = new ArrayList<>();

        for (int element: elements) {
            binaryInsert(element, result);
        }

        result.forEach(System.out::println);
    }

    private static void binaryInsert(int element, List<Integer> result) {
        if (result.isEmpty()) {
            result.add(element);
            return;
        }
        int front = 0;
        int back = result.size() - 1;

        while( front <= back) {
            int mid = (back - front) / 2 + front;

            if (result.get(mid) > element) {
                back = mid - 1;
            } else {
                front = mid + 1;
            }
        }
        result.add(front, element);
    }

    private static List<Integer> mergeSort(List<Integer> elements) {
        if (elements.isEmpty()) {
            return elements;
        }
        int mid = elements.size() / 2;
        List<Integer> frontList = elements.subList(0, mid);
        List<Integer> endList = elements.subList(mid, elements.size() );

        return merge(mergeSort(frontList), mergeSort(endList));

    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int rightIdx = 0;
//        for () {
//
//        }
        return result;
    }

}