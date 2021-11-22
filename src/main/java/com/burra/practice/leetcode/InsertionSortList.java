package com.burra.practice.leetcode;

public class InsertionSortList {

  public ListNode insertionSortList(ListNode head) {
    ListNode result = new ListNode();
    ListNode curr = head, prevNode, nxtNode;
    while (curr != null) {
      prevNode = result;
      nxtNode = result.next;
      while (nxtNode != null) {
        if (curr.val < nxtNode.val) {
          break;
        }
        prevNode = nxtNode;
        nxtNode = nxtNode.next;
      }
      ListNode nxtItr = curr.next;
      curr.next = nxtNode;
      prevNode.next = curr;
      curr = nxtItr;
    }
    return result.next;
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
