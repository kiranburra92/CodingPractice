package com.burra.practice.leetcode;

public class convertBinaryNumberInLinkedListToInteger {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public int getDecimalValue(ListNode head) {
        int result = head.val;
        while (head.next != null){
            result = result * 2 + head.next.val;
//            result = (result << 1) | head.next.val;
            head = head.next;
        }
        return result;
    }
}
