package com.burra.practice.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int carry = 0;
        int sum  = 0;
        while(l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            sum = (l1.val + carry)%10;
            carry = (l1.val + carry)/10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            sum = (l2.val + carry)%10;
            carry = (l2.val + carry)/10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry != 0) {
            temp.next = new ListNode(carry);

        }
        return head.next;
    }
}
