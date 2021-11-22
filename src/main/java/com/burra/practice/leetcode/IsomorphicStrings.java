package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character, but a character may map to itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add" Output: true Example 2:
 * <p>
 * Input: s = "foo", t = "bar" Output: false Example 3:
 * <p>
 * Input: s = "paper", t = "title" Output: true
 */
public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Character> myMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = myMap.getOrDefault(s.charAt(i), '\0');
      if (c == '\0' && myMap.containsValue(t.charAt(i))) {
        return false;
      }
      if (c == '\0') {
        myMap.put(s.charAt(i), t.charAt(i));
      } else if (c != t.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
