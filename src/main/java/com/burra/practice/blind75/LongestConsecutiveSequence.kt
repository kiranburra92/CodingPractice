package com.burra.practice.blind75

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */
class LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        val booleanArray = BooleanArray(Int.MAX_VALUE - 1)
        var max = 0
        var temp = 0
        nums.forEach { booleanArray[it - 1] = true }
        for (i in 0 until booleanArray.size - 2) {
            if (booleanArray[i]) {
                temp++
                if (!booleanArray[i + 1]) {
                    max = max.coerceAtLeast(temp)
                    temp = 0
                }
            }
        }
        return max
    }
}

fun main() {
    var longestConsecutiveSequence = LongestConsecutiveSequence()
    println(longestConsecutiveSequence.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}