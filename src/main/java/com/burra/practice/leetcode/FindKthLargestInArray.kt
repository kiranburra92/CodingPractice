package com.burra.practice.leetcode

import java.util.PriorityQueue

class FindKthLargestInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq: PriorityQueue<Int> = PriorityQueue()
        nums.forEach { i -> pq.add(i) }

        repeat(nums.size - k) {
            pq.poll()
        }
        return pq.peek()
    }

}

fun main() {
    val findKthLargest = FindKthLargestInArray()
//    findKthLargest.findKthLargest([1,2,3], 4)
}
