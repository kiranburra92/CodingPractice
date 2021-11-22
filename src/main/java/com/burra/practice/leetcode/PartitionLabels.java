package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so
 * that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8]
 * <p>
 * Explanation: The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that each letter appears in
 * at most one part. A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

  public List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); ++i) {
      last[S.charAt(i) - 'a'] = i;
    }

    int j = 0, anchor = 0;
    List<Integer> ans = new ArrayList();
    for (int i = 0; i < S.length(); ++i) {
      j = Math.max(j, last[S.charAt(i) - 'a']);
      if (i == j) {
        ans.add(i - anchor + 1);
        anchor = i + 1;
      }
    }
    return ans;
  }
}
