package com.burra.practice.blind75

import java.util.LinkedList
import java.util.Queue

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val que: Queue<Char> = LinkedList()
        var result = 0
        s.forEach {
            if (que.contains(it)) {
                while (que.peek() != it) {
                    que.poll()
                }
                que.poll()
            }
            que.add(it)
            result = result.coerceAtLeast(que.size)
        }
        return result
    }
}