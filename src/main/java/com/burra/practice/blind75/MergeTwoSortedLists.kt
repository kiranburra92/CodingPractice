package com.burra.practice.blind75

/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
class MergeTwoSortedLists {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var list_1 = list1
        var list_2 = list2
        var result = ListNode(0)
        var dummy = result
        while(list_1 != null && list_2 != null) {
            if(list_1.`val` <= list_2.`val`){
                dummy.next = list_1
                list_1 = list_1.next
            } else {
                dummy.next = list_2
                list_2 = list_2.next
            }
            dummy = dummy.next!!
        }
        if(list_1 == null && list_2 != null)
            dummy.next = list_2
        else
            dummy.next = list_1

        return result.next
    }
}