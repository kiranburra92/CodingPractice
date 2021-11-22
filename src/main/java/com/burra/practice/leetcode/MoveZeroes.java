package com.burra.practice.leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * <p>
 * You must do this in-place without making a copy of the array. Minimize the total number of operations.
 */
public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    for (; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j] = nums[i];
        j++;
      }
    }
    for (; j < nums.length; j++) {
      nums[j] = 0;
    }
  }
}
