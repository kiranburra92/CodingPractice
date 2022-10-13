package com.burra.practice.blind75

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        val my = mutableListOf(*intervals)

        if (my.isNotEmpty()) {
            for (i in my.indices) {
                if (my[i][0] > newInterval[0]) {
                    my.add(i, intArrayOf(newInterval[0], newInterval[1]))
                    newInterval[0] = 0
                    newInterval[1] = 0
                    break
                }
            }
            if (newInterval[0] != 0 && newInterval[1] != 0)
                my.add(newInterval)

            result.add(my[0])
            my.forEachIndexed { _, ints ->
                run {
                    if (result.last()[0] <= ints[0] && result.last()[1] >= ints[0]) {
                        result.last()[1] = result.last()[1].coerceAtLeast(ints[1])
                    } else
                        result.add(ints)
                }
            }
        } else
            result.add(newInterval)

        return result.toTypedArray()
    }
}

fun main() {
    val insertInterval = InsertInterval()
    insertInterval.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
}