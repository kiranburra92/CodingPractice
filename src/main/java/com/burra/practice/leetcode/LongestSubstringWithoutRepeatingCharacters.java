package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = 1;
        int j = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0 ; i< s.length() ; i++) {
            if(mp.containsKey(s.charAt(i)))
                j = Math.max(mp.get(s.charAt(i)), j);
            ans = Math.max(ans, i - j+1);
            mp.put(s.charAt(i), i+1);
        }
        return ans;
    }
}
