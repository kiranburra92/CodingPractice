package com.burra.practice.blind75

class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(Comparator {o1, o2 -> o1[1].compareTo(o2[1]) })
        var result  = 0
        var prevValue = intervals[0][1]
        for(i in 1 until intervals.size) {
            if(intervals[i][0] < prevValue)
                result++
            else
                prevValue = intervals[i][1]
        }
        return result
    }
}

fun main() {
    var nonOverlappingIntervals = NonOverlappingIntervals()
    nonOverlappingIntervals.eraseOverlapIntervals(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3)))
}