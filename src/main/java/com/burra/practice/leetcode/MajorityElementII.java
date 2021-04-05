package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {

        // at max only two elements can be present more than n/3
        int one = Integer.MAX_VALUE;
        int two = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int i : nums){
            if(one == i){
                count1++;
            }
            else if( i == two) {
                count2++;
            }
            else if(count1 == 0) {
                one = i;
                count1++;
            }
            else if(count2 == 0) {
                two = i;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int i : nums){
            if(i == one){
                count1++;
            }
            else if(i == two) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length/3)
            res.add(one);
        if(count2 > nums.length/3)
            res.add(two);

        return res;
    }
}
