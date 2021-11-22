package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class longestPalindrome {

  public static int longestPalindrome(String s) {
    Map<Character, Integer> m = new HashMap<>();
    for (Character c : s.toCharArray()) {
      m.put(c, m.getOrDefault(c, 0) + 1);
    }
    int len = 0;
    boolean flag = false;
    for (Map.Entry<Character, Integer> entry : m.entrySet()) {
      if (entry.getValue() % 2 == 1) {
        flag = true;
      }
      len = len + (entry.getValue() / 2) * 2;
    }
    return flag ? len + 1 : len;
  }

  public static void main(String... args) {
    System.out.println(longestPalindrome("abccccdd"));
  }
}
