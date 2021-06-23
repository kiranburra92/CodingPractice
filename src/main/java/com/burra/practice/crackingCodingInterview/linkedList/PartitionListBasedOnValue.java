package com.burra.practice.crackingCodingInterview.linkedList;

/**
 * Partition list based on a value, such that all values less that k should appear before all vales greater than k
 */
public class PartitionListBasedOnValue {
    // clear but not stable
    public LinkedListNode partitionListByK(LinkedListNode head, int k) {
        LinkedListNode start = head;
        LinkedListNode end = head;

        while (head != null) {
            LinkedListNode next = head.next;
            if(head.data < k) {
                head.next = start;
                start = head;
            }
            else {
                end.next = head;
                end = head;
            }
            head = next;
        }
        end.next = null;
        return start;
    }

    // stable
    public LinkedListNode partitionListByK1(LinkedListNode head, int k) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (head != null) {
            LinkedListNode next = head.next;
            head.next = null;
            if(head.data < k) {
                if(beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            }
            else {
                if(afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }

        if(beforeEnd == null) return afterStart;
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
