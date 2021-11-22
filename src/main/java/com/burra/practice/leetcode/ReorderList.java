package com.burra.practice.leetcode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * <p>
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {

  public static ListNode reverseOrder(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = head;
    ListNode curr = head.next;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }

    head.next = null;

    return pre;
  }

  public void reorderList(ListNode head) {
    if (head != null && head.next != null) {

      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode second = slow.next;
      slow.next = null;

      second = reverseOrder(second);

      ListNode p1 = head;
      ListNode p2 = second;

      while (p2 != null) {
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;

        p1.next = p2;
        p2.next = temp1;

        p1 = temp1;
        p2 = temp2;
      }
    }
  }

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
}
