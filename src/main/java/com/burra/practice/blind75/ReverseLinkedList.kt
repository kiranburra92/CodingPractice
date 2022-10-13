package com.burra.practice.blind75

class ReverseLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        var dummyHead = head
        var newHead: ListNode? = null
        while (dummyHead != null) {
            var temp = dummyHead.next
            dummyHead.next = newHead
            newHead = dummyHead
            dummyHead = temp
        }
        return newHead
    }
}