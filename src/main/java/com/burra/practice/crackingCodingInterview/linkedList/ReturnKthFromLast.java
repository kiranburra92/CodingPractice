package com.burra.practice.crackingCodingInterview.linkedList;

public class ReturnKthFromLast {

  public LinkedListNode KthFromLastNode(LinkedListNode head, int k) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    for (int i = 0; i < k; i++) {
      if (fast != null) {
        fast = fast.next;
      } else {
        return null;
      }
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
