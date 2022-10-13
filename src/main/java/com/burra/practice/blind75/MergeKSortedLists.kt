package com.burra.practice.blind75

import java.util.*

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */
class MergeKSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode> { l1, l2 -> l1.`val`.compareTo(l2.`val`) }
        var dummy = ListNode(0)
        var current = dummy

        lists.forEach { queue.add(it) }
        while (queue.isNotEmpty()) {
            var temp = queue.poll()
            if (temp.next != null) {
                queue.add(temp.next)
            }
            dummy.next = temp
            dummy = dummy.next!!
        }

        return current.next
    }
}