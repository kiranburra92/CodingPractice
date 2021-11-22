package com.burra.practice.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int maxend = 0;
    for (int i : nums) {
      maxend = maxend + i;
      if (max < maxend) {
        max = maxend;

      }
      if (maxend < 0) {
        maxend = 0;
      }
    }
    return max;
  }
}
