package com.burra.practice.crackingCodingInterview.linkedList;

/**
 * 765 -> [5, 6, 7]
 * +
 * 321 -> [1, 2, 3]
 * =
 * 1086 -> [6, 8, 0, 1]
 */
public class SumOfLinkedListReverseOrder {
    public LinkedListNode sum1(LinkedListNode l1, LinkedListNode l2) {
        return sum1Helper(l1, l2, 0);
    }

    private LinkedListNode sum1Helper(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;
        LinkedListNode result = new LinkedListNode();
        int val = carry;
        if (l1 != null)
            val += l1.data;
        if (l2 != null)
            val += l2.data;

        result.data = val%10;
        if(l1 != null || l2 != null){
            result.next = sum1Helper(l1 != null ? l1 : null, l2 != null ? l2 : null, val/10);
        }
        return result;
    }

    public LinkedListNode sum2(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode result = new LinkedListNode();
        LinkedListNode ref = result;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.data + l2.data + carry;
            LinkedListNode temp = new LinkedListNode(sum%10);
            carry = sum/10;
            ref.next = temp;
            ref = ref.next;
        }
        while (l1 != null) {
            sum = l1.data + carry;
            LinkedListNode temp = new LinkedListNode(sum%10);
            carry = sum/10;
            ref.next = temp;
            ref = ref.next;
        }
        while (l2 != null) {
            sum = l2.data + carry;
            LinkedListNode temp = new LinkedListNode(sum%10);
            carry = sum/10;
            ref.next = temp;
            ref = ref.next;
        }
        if(carry == 1) {
            LinkedListNode temp = new LinkedListNode(carry);
            ref.next = temp;
        }
        return result.next;
    }
}
