package com.burra.practice.blind75

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val myMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i -> myMap[i] = index }
        nums.forEachIndexed { index, i -> run {
            val ind = myMap.getOrDefault(target-i, -1)
            if(ind != -1 && ind != index)
                return intArrayOf(index, ind)
        } }
        return intArrayOf(0, 0)
    }
}