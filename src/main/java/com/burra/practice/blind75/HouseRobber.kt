package com.burra.practice.blind75

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 * can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */
class HouseRobber {

    /**
     * At every i-th house we have two choices to make, i.e., rob the i-th house or don't rob it.

     * Case1 : Don't rob the i-th house - then we can rob the i-1 th house...so we will have max money robbed till i-1 th
     * house
     *
     * Case 2 : Rob the i-th house - then we cann't rob the i-1 th house but we can rob i-2 th house....so we will have
     * max money robbed till i-2 th house + money of i-th house.
     *
     * Example:
     *
     * 1.) If the array is [1,5,3] then robber will rob the 1st index house because arr[1] > arr[0]+arr[2]
     * (i.e., at last index, arr[i-1] > arr[i-2]+arr[i])
     *
     *
     * 2.) If the array is [1,2,3] then robber will rob the 0th and 2nd index house because arr[0]+arr[2] > arr[1]
     * (i.e., at last index, arr[i-2] + arr[i] > arr[i-1])
     */
    fun rob(nums: IntArray): Int {
        val size = nums.size
        if (size == 1)
            return nums[0]
        val dp = IntArray(size)
        dp[0] = nums[0]
        dp[1] = nums[1].coerceAtLeast(nums[0])

        for (i in 2 until size) {
            dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + nums[i])
        }
        return dp[size - 1]
    }
}