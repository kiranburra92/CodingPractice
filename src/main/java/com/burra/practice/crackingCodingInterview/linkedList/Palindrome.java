package com.burra.practice.crackingCodingInterview.linkedList;

import java.util.Stack;

public class Palindrome {

  // reverse and compare
  public boolean isPalindrome1(LinkedListNode head) {
    LinkedListNode reverseHead = reverse(head);
    while (head != null) {
      if (head.data != reverseHead.data) {
        return false;
      }
      head = head.next;
      reverseHead = reverseHead.next;
    }
    return true;
  }

  private LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode newHead = null;
    while (head != null) {
      LinkedListNode temp = new LinkedListNode(head.data);
      temp.next = newHead;
      newHead = temp;
      head = head.next;
    }
    return newHead;
  }

  // travers till mid point while pushing to stack
  public boolean isPalindrome2(LinkedListNode head) {
    Stack<Integer> myStack = new Stack<>();
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    while (fast != null && fast.next != null) {
      myStack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    // list size is odd number
    if (fast.next != null) {
      slow = slow.next;
    }
    while (slow != null) {
      if (slow.data != myStack.pop()) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }
}
