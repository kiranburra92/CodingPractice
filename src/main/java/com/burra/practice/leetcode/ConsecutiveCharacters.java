package com.burra.practice.leetcode;

/**
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only
 * one unique character.
 * <p>
 * Return the power of the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 * <p>
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 * <p>
 * Input: s = "triplepillooooow"
 * Output: 5
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s == null || s == "")
            return 0;

        int result = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                temp++;
                result = Math.max(temp, result);
            } else {
                temp = 1;
            }
        }
        return result;
    }
}
