package com.burra.practice.blind75

/**
 * Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 */
class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var count = 0
        for (i in s.indices) {
            count += checkPalindromes(s, i, i)
            count += checkPalindromes(s, i, i + 1)
        }

        return count
    }

    private fun checkPalindromes(s: String, l: Int, r: Int): Int {
        var count = 0
        var left = l
        var right = r
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            count++
            left--
            right++
        }
        return count
    }
}