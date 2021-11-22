package com.burra.practice.leetcode;

public class MiddleoftheLinkedList {

  public static ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast.next != null) {
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String args[]) {
    ListNode node_5 = new ListNode(5);
    ListNode node_4 = new ListNode(4, node_5);
    ListNode node_3 = new ListNode(3, node_4);
    ListNode node_2 = new ListNode(2, node_3);
    ListNode node_1 = new ListNode(1, node_2);
    System.out.println(middleNode(node_1).val);
  }

  public static class ListNode {

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
}
