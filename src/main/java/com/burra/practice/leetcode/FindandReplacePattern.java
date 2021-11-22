package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the
 * answer in any order.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the
 * pattern with p(x), we get the desired word.
 * <p>
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and
 * no two letters map to the same letter.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" Output: ["mee","aqq"] Explanation: "mee"
 * matches the pattern because there is a permutation {a -> m, b -> e, ...}. "ccc" does not match the pattern because {a
 * -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 * <p>
 * Example 2:
 * <p>
 * Input: words = ["a","b","c"], pattern = "a" Output: ["a","b","c"]
 */
public class FindandReplacePattern {

  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();
    for (String s : words) {
      if (match(s, pattern)) {
        result.add(s);
      }
    }
    return result;
  }

  private boolean match(String s, String pattern) {
    if (s.length() != pattern.length()) {
      return false;
    }
    Map<Character, Character> forward = new HashMap<>();
    Map<Character, Character> backward = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char m = s.charAt(i);
      char p = pattern.charAt(i);
      if (!forward.containsKey(m)) {
        forward.put(m, p);
      }
      if (!backward.containsKey(p)) {
        backward.put(p, m);
      }
      if (forward.get(m) != p || backward.get(p) != m) {
        return false;
      }
    }
    return true;
  }
}
