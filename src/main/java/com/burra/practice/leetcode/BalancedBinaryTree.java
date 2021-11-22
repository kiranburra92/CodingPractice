package com.burra.practice.leetcode;

public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int lh = height(root.left);
    int rh = height(root.right);
    if (Math.abs(lh - rh) <= 1 && isBalanced(root.right) && isBalanced(root.left)) {
      return true;
    }
    return false;
  }

  public int height(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(height(node.left), height(node.right)) + 1;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
