package com.burra.practice.crackingCodingInterview.linkedList;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class RemoveDuplicateInLinkedList {

  public LinkedListNode removeDuplicateWithUsingExtraSpace(LinkedListNode head) {
    LinkedListNode first = head;
    LinkedListNode second;
    while (first != null) {
      second = first;
      while (second.next != null) {
        if (second.next.data == first.data) {
          second.next = second.next.next;
        } else {
          second = second.next;
        }
      }
      first = first.next;
    }
    return head;
  }

  public LinkedListNode removeDuplicateWithExtraSpace(LinkedListNode head) {
    HashSet<Integer> set = new LinkedHashSet<>();
    LinkedListNode first = head;
    LinkedListNode previous = null;
    while (first != null) {
      if (set.contains(first.data)) {
        previous.next = first.next;
      } else {
        set.add(first.data);
        previous = first;
      }
      first = first.next;
    }
    return head;
  }
}
