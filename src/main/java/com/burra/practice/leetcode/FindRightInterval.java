package com.burra.practice.leetcode;

import java.util.Arrays;

/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger
 * than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum
 * start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the
 * interval i. Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * <p>
 * You may assume the interval's end point is always bigger than its start point. You may assume none of these intervals
 * have the same start point.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4]. For [2,3], the interval [3,4] has minimum-"right"
 * start point; For [1,2], the interval [2,3] has minimum-"right" start point.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4]. For [2,3], the interval [3,4] has
 * minimum-"right" start point.
 */
public class FindRightInterval {

  public int[] findRightInterval(int[][] intervals) {
    int[] result = new int[intervals.length];
    int min = intervals[0][0], max = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      min = Math.min(min, intervals[i][0]);
      max = Math.max(max, intervals[i][1]);
    }

    int[] buckets = new int[max - min + 1];
    Arrays.fill(buckets, -1);
    for (int i = 0; i < intervals.length; i++) {
      buckets[intervals[i][0] - min] = i;
    }

    for (int i = buckets.length - 2; i >= 0; i--) {
      if (buckets[i] == -1) {
        buckets[i] = buckets[i + 1];
      }
    }

    for (int i = 0; i < intervals.length; i++) {
      result[i] = buckets[intervals[i][1] - min];
    }
    return result;
  }
}
