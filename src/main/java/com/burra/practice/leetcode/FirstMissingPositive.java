package com.burra.practice.leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0] Output: 3 Example 2:
 * <p>
 * Input: [3,4,-1,1] Output: 2 Example 3:
 * <p>
 * Input: [7,8,9,11,12] Output: 1 Follow up:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) {
      return 1;
    }
    int maxPositive = 0;
    for (int i : nums) {
      if (maxPositive < i) {
        maxPositive = i;
      }
    }
    int j = 1;
    for (; j <= maxPositive; j++) {
      boolean flag = true;
      for (int n : nums) {
        if (j == n) {
          flag = false;
        }
      }
      if (flag) {
        return j;
      }
    }
    return j;

    /**
     * Set<Integer> hs=new HashSet<Integer>();
     *
     *         for(int j=0;j<nums.length;j++){
     *              hs.add(nums[j]);
     *         }
     *
     *         for(int k=1;k<Integer.MAX_VALUE;k++){
     *             if(!hs.contains(k)){
     *                return k;
     *             }
     *         }
     *
     *         return nums.length;
     */
  }
}
