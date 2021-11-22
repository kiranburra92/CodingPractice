package com.burra.practice.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation: Return true because "leetcode" can be
 * segmented as "leet code". Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true Explanation: Return true because "applepenapple"
 * can be segmented as "apple pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output: false
 */
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    return wordBreakHelper(s, new HashSet<>(wordDict), new Boolean[s.length()], 0);
  }

  private boolean wordBreakHelper(String s, Set<String> words, Boolean[] memory, int start) {
    if (start == s.length()) {
      return true;
    }
    if (memory[start] != null) {
      return memory[start];
    }

    for (int end = start + 1; end <= s.length(); end++) {
      if (words.contains(s.substring(start, end)) && wordBreakHelper(s, words, memory, end)) {
        return memory[start] = true;
      }
    }
    return memory[start] = false;
  }
}
