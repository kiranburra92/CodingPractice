package com.burra.practice.leetcode;

import java.util.Arrays;

/**
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where
 * horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
 * verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 * <p>
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the
 * arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3] Output: 4 Explanation: The figure above
 * represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the
 * green piece of cake has the maximum area.
 * <p>
 * Example 2:
 * <p>
 * Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1] Output: 6 Explanation: The figure above represents
 * the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and
 * yellow pieces of cake have the maximum area.
 * <p>
 * Example 3:
 * <p>
 * Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3] Output: 9
 */
public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int maxH = horizontalCuts[0];
    int maxV = verticalCuts[0];
    int i = 0;
    for (; i < horizontalCuts.length - 1; i++) {
      maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
    }
    maxH = Math.max(maxH, h - horizontalCuts[i]);

    i = 0;
    for (; i < verticalCuts.length - 1; i++) {
      maxV = Math.max(maxV, verticalCuts[i + 1] - verticalCuts[i]);
    }
    maxV = Math.max(maxV, w - verticalCuts[i]);

    return (int) ((long) maxH * maxV % 1000000007);
  }
}
