package com.burra.practice.leetcode;

public class SameBinaryTree {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;
        else
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
