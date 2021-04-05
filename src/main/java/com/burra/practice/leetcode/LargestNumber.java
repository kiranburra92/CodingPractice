package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int count = 0;

        List<Integer> n = new ArrayList<>();
        for (int i : nums) {
            if(i == 0){
                count++;
            }
            n.add(i);
        }
        if(nums.length == count)
            return "0";
        Collections.sort(n, (o1, o2) -> {
            String xy = o1.toString() + o2.toString();
            String yx = o2.toString() + o1.toString();
            return xy.compareTo(yx)>0 ? -1 : 1;
        });
        String r = "";
        for (Integer i : n)
            r += i.toString();
        return r;
    }
}
