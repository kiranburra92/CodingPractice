package com.burra.practice.leetcode;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "cbbd" Output: "bb"
 * <p>
 * Example 3:
 * <p>
 * Input: s = "a" Output: "a"
 * <p>
 * Example 4:
 * <p>
 * Input: s = "ac" Output: "a"
 */
public class LongestPalindromicSubstring {

  //time out
  public String longestPalindrome(String s) {
    String result = "";
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String t = s.substring(i, j);
        if (isPalindrome(t)) {
          if (t.length() > max) {
            max = t.length();
            result = t;
          }
        }
      }
    }
    return result;
  }

  public boolean isPalindrome(String s) {
    int j = s.length() - 1;
    int i = 0;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
