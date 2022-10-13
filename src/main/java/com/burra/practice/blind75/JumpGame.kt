package com.burra.practice.blind75

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var i = 0
        var maxReach = 0
        while (i <= maxReach && i < nums.size) { // check i <= maxReach if we are in unreachable index since we are
            // moving linear
            maxReach = maxReach.coerceAtLeast(i + nums[i])
            i++
        }
        return i == nums.size
    }
}