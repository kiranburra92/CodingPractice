package com.burra.practice.crackingCodingInterview.linkedList;

/**
 * 765 -> [7,6,5] + 3210 -> [3,2,1] = 3975 -> [3,9,7,5]
 */
public class SumOfLinkedListOriginalOrder {

  public LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
    int len1 = lengthOfList(l1);
    int len2 = lengthOfList(l2);
    if (len1 < len2) {
      for (int i = 0; i < len2 - len1; i++) {
        l1 = padNumberAtBeginning(l1, 0);
      }
    }
    if (len2 < len1) {
      for (int i = 0; i < len1 - len2; i++) {
        l2 = padNumberAtBeginning(l2, 0);
      }
    }
    PartialSum sum = addHelper(l1, l2);
    if (sum.carry > 0) {
      return padNumberAtBeginning(sum.sum, sum.carry);
    }
    return sum.sum;
  }

  private PartialSum addHelper(LinkedListNode l1, LinkedListNode l2) {
    if (l1 == null || l1 == null) {
      PartialSum sum = new PartialSum();
      return sum;
    }
    PartialSum sum = addHelper(l1.next, l2.next);
    int val = sum.carry + l1.data + l2.data;

    LinkedListNode full_result = padNumberAtBeginning(sum.sum, val % 10);
    sum.sum = full_result;
    sum.carry = val / 10;
    return sum;

  }

  private LinkedListNode padNumberAtBeginning(LinkedListNode list, int i) {
    LinkedListNode newHead = new LinkedListNode(i);
    if (list != null) {
      newHead.next = list;
    }
    return newHead;
  }

  private int lengthOfList(LinkedListNode list) {
    int count = 0;
    while (list != null) {
      count++;
      list = list.next;
    }
    return count;
  }

  class PartialSum {

    LinkedListNode sum;
    int carry = 0;
  }
}
