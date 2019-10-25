package com.burra.practice.leetcode;

public class RemoveDuplicatesfromSortedList {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }
}
