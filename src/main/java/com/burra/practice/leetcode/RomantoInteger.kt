package com.burra.practice.leetcode

class RomantoInteger {
    fun romanToInt(s: String): Int {
        var ans = 0
        var num = 0
        var prev = 0

        for (i in s.length - 1 downTo 0) {
            when (s[i]) {
                'I' -> num = 1
                'V' -> num = 5
                'X' -> num = 10
                'L' -> num = 50
                'C' -> num = 100
                'D' -> num = 500
                'M' -> num = 1000
            }
            if(prev > num)
                ans -= num
            else
                ans += num
            prev = num
        }
        return ans
    }
}
