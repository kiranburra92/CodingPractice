package com.burra.practice.crackingCodingInterview.linkedList;

// given two linkedList, find the intersection node if present
public class FindIntersectionIfPresent {
    // if one list is larger than order, traverse longest list by k steps
    public LinkedListNode intersection(LinkedListNode l1, LinkedListNode l2) {
        if(getTail(l1) != getTail(l2))
            return null;

        int len1 = findLength(l1);
        int len2 = findLength(l2);

        LinkedListNode small = len1 < len2 ? l1 : l2;
        LinkedListNode large = len1 < len2 ? l2 : l1;
        large = traverseTillK(large, Math.abs(len1 - len2));

        while (small != null && large != null) {
            if(small == large){
                return small;
            }
            small = small.next;
            large = large.next;
        }
        return null;
    }

    private LinkedListNode traverseTillK(LinkedListNode large, int abs) {
        for(int i = 0 ; i < abs  && large != null ; i++) {
            large = large.next;
        }
        return large;
    }

    private int findLength(LinkedListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private LinkedListNode getTail(LinkedListNode node) {
        if(node == null) return  null;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}
