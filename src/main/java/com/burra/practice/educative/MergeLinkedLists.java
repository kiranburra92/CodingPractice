package com.burra.practice.educative;

/**
 * Given two sorted linked lists, merge them so that the resulting linked list is also sorted. Consider two sorted
 * linked lists and the merged list below them as an example.
 * <p>
 * head1
 * 4
 * 8
 * 15
 * 19
 * NULL
 * <p>
 * head2
 * 7
 * 9
 * 10
 * 16
 * NULL
 * <p>
 * head1
 * 4
 * 7
 * 8
 * 9
 * 10
 * 15
 * 16
 * 19
 * NULL
 */
public class MergeLinkedLists {
    class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static LinkedListNode merge_sorted(
            LinkedListNode head1,
            LinkedListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        LinkedListNode tempHead1 = head1;
        LinkedListNode tempHead2 = head2;
        if(head1.val > head2.val ) {
        }
        return head1;
    }

}
