package com.burra.practice.leetcode;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that: arr[0] < arr[1] < ... < arr[i - 1] < A[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,1] Output: false Example 2:
 * <p>
 * Input: arr = [3,5,5] Output: false Example 3:
 * <p>
 * Input: arr = [0,3,2,1] Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 104 0 <= arr[i] <= 104
 */
public class ValidMountainArray {

  public boolean validMountainArray(int[] A) {
    int N = A.length;
    int i = 0;

    // walk up
    while (i + 1 < N && A[i] < A[i + 1]) {
      i++;
    }

    // peak can't be first or last
    if (i == 0 || i == N - 1) {
      return false;
    }

    // walk down
    while (i + 1 < N && A[i] > A[i + 1]) {
      i++;
    }

    return i == N - 1;
  }
}
