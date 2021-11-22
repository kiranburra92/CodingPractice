package com.burra.practice.crackingCodingInterview.linkedList;

// find loop node if present
public class LoopDetection {

  public LinkedListNode loopNode(LinkedListNode node) {
    LinkedListNode slow = node;
    LinkedListNode fast = node;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }

    slow = node;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
