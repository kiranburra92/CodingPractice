package com.burra.practice.leetcode;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all
 * the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {
    int i = 0;
    int j = A.length - 1;
    int[] result = new int[j + 1];
    for (int p = 0; p < A.length && i <= j; p++) {
      if (A[p] % 2 == 0) {
        result[i] = A[p];
        i++;
      } else {
        result[j] = A[p];
        j--;
      }
    }
    return result;
  }
}
