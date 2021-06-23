package com.burra.practice.leetcode;

public class ConvertSortedListtoBinarySearchTree {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return buildBSTUtil(head, null);
    }

    private TreeNode buildBSTUtil(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != tail && fastPointer.next != tail) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        TreeNode bstHead = new TreeNode(slowPointer.val);
        bstHead.left = buildBSTUtil(head, slowPointer);
        bstHead.right = buildBSTUtil(slowPointer.next, tail);

        return bstHead;
    }

}
