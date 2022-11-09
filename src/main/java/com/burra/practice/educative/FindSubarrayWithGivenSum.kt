package com.burra.practice.educative

object FindSubarrayWithGivenSum {
    fun printSubarray(arr: IntArray, sum: Int) {
        val n = arr.size
        var curr_sum = arr[0]
        var start = 0
        var i = 0
        while (i < n) {
            if (curr_sum > sum) {
                curr_sum -= arr[start]
                start++
            }
            if (curr_sum == sum) {
                println("$start $i")
                return
            }
            curr_sum += arr[i]
            i++
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(15, 2, 4, 8, 9, 5, 10, 23)
        printSubarray(arr, 23)
    }
}