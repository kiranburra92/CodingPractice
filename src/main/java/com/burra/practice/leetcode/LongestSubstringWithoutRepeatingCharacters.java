package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that the answer must be
 * a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Example 4:
 * <p>
 * Input: s = "" Output: 0
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int ans = 1;
    int j = 0;
    Map<Character, Integer> mp = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (mp.containsKey(s.charAt(i))) {
        j = Math.max(mp.get(s.charAt(i)), j);
      }
      ans = Math.max(ans, i - j + 1);
      mp.put(s.charAt(i), i + 1);
    }
    return ans;
  }
}
