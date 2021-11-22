package com.burra.practice.leetcode;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumber {

  public int singleNumber(int[] nums) {
    int num = 0;
    for (int n : nums) {
      num ^= n;
    }
    return num;
  }
}
