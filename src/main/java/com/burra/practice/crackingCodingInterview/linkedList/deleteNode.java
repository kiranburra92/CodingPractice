package com.burra.practice.crackingCodingInterview.linkedList;

public class deleteNode {
    public LinkedListNode delete(LinkedListNode head, int d) {
        if (head == null) return null;
        LinkedListNode n = head;

        if (n.data == d)
            return n.next;

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return head;
    }
}
