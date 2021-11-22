package com.burra.practice.leetcode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL Explanation: rotate 1 steps to the right:
 * 5->1->2->3->4->NULL rotate 2 steps to the right: 4->5->1->2->3->NULL Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4 Output: 2->0->1->NULL Explanation: rotate 1 steps to the right: 2->0->1->NULL rotate 2
 * steps to the right: 1->2->0->NULL rotate 3 steps to the right: 0->1->2->NULL rotate 4 steps to the right:
 * 2->0->1->NULL
 */
public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }

    int length = 1;
    ListNode lastNode = head;
    ListNode tempHead = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
      length++;
    }
    int rem = length - (k % length);
    while (rem-- > 0) {
      lastNode.next = new ListNode(tempHead.val);
      lastNode = lastNode.next;
      tempHead = tempHead.next;
    }
    return tempHead;
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
