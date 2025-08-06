package com.inspire12.algorithm.template.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortBySublist implements Sort<Integer> {

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int pivot = list.get(list.size() / 2);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();

        for (Integer element : list) {
            if (pivot < element) {
                right.add(element);
            } else if (pivot > element) {
                left.add(element);
            } else {
                equals.add(element);
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(sort(left));
        result.addAll(sort(equals));
        result.addAll(sort(right));

        return result;
    }
}
