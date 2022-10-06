package com.burra.practice.blind75


/**
 * Given a string s, return the longest palindromic substring in s.

A string is called a palindrome string if the reverse of that string is the same as the original string.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
class LongestPalindromicSubstring {
    // Expand from each index
    fun longestPalindrome(s: String): String {
        var result = ""
        var max = -1
        for (i in s.indices) {
            var l1 = expandFromIndex(s, i, i) // expand from 1 point for ex: aba
            val l2 = expandFromIndex(s, i, i + 1) // expand from two point for ex: abba
            l1 = l1.coerceAtLeast(l2)
            if (max < l1) {
                max = l1
                result = s.substring(i - (max - 1) / 2, 1 + i + max / 2)
            }
        }
        return result
    }

    private fun expandFromIndex(s: String, left: Int, right: Int): Int {
        var i = left
        var j = right
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--
            j++
        }
        return j - i - 1
    }
}