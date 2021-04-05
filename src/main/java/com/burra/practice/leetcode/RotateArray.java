package com.burra.practice.leetcode;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int rem = nums.length - k%nums.length;
        int temp;
        while (rem-- > 0){
            temp = nums[0];
            for(int i=0;i<nums.length-1;i++){
                nums[i] = nums[i+1];
            }
            nums[nums.length-1]=temp;
        }
    }
}
