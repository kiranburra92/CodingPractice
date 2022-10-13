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
        if (nums.isEmpty())
            return 0
        val set: HashSet<Int> = hashSetOf()
        nums.forEach { set.add(it) }
        var result = 1
        nums.forEach {
            run {
                if (set.contains(it + 1) && !set.contains(it - 1)) {
                    var tempMax = 0
                    var currentNumber = it
                    while (set.contains(currentNumber)) {
                        tempMax++
                        currentNumber++
                    }
                    result = result.coerceAtLeast(tempMax)
                }
            }
        }
        return result
    }
}

fun main() {
    val longestConsecutiveSequence = LongestConsecutiveSequence()
    println(longestConsecutiveSequence.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}