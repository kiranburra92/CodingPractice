package com.burra.practice.blind75

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the
mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").


Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */
class DecodeWays {
    fun numDecodings(s: String): Int {
        if (s.isEmpty() || s[0] == '0') return 0
        val memory = IntArray(s.length + 1)
        memory[0] = 1
        val w1 = traversCount(s, 1, s.substring(0, 1), memory)
        val w2 = if (s.length > 1) traversCount(s, 2, s.substring(0, 2), memory) else 0
        return w1 + w2
    }

    private fun traversCount(s: String, index: Int, tempString: String, memory: IntArray): Int {
        val intValue = tempString.toInt()
        if (tempString[0] == '0' || intValue == 0 || intValue > 26 || index > s.length)
            return 0
        if (index == s.length)
            return 1
        if (memory[index] != 0)
            return memory[index]
        val w1 = traversCount(s, index + 1, s.substring(index, index + 1), memory)
        val w2 = if (index < s.length - 1) traversCount(s, index + 2, s.substring(index, index + 2), memory) else 0

        memory[index] = w1 + w2
        return memory[index]
    }
}

fun main() {
    val decodeWays = DecodeWays()
    println(decodeWays.numDecodings("226"))
    println(decodeWays.numDecodings("111111111111111111111111111111111111111111111"))
}