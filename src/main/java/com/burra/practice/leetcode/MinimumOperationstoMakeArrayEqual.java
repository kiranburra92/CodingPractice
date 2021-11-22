package com.burra.practice.leetcode;

/**
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 * <br>
 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to
 * arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is
 * guaranteed that all the elements of the array can be made equal using some operations.
 * <br>
 * Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements
 * of arr equal.
 *
 * <br>
 * <p>
 * Example 1:
 * <br>
 * Input: n = 3 <br> Output: 2 <br> Explanation: arr = [1, 3, 5] <br> First operation choose x = 2 and y = 0, this leads
 * arr to be [2, 3, 4] <br> In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].<br>
 * <p>
 * Example 2: <br>
 * <p>
 * Input: n = 6 <br> Output: 9 <br>
 * <p>
 * <p>
 * Constraints:<br>
 * <p>
 * 1 <= n <= 10^4<br>
 */
public class MinimumOperationstoMakeArrayEqual {

  public int minOperations(int n) {
    int total = 0;
    int sum = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = (2 * i) + 1;
    }
    for (int i : a) {
      sum += i;
    }
    sum = sum / n;
    for (int i : a) {
      total += Math.abs(sum - i);
    }
    return total / 2;
  }
}
