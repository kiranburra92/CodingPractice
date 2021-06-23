package com.burra.practice.educative;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one
 * number x. You have to find x. The input array is not sorted. Look at the below array and give it a try before
 * checking the solution.
 *
 * 3
 * 7
 * 1
 * 2
 * 8
 * 4
 * 5
 * n = 8 missing number = 6
 */
public class Findthemissingnumberinthearray {
    public int findMissing(List<Integer> input) {
        int length = input.size() + 1;
        int total = (length * (length + 1))/2;
        int sum = input.stream().reduce(0, Integer::sum);
        return total - sum;
    }
}
