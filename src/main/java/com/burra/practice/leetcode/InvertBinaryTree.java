package com.burra.practice.leetcode;

public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    return inv(root);
  }

  private TreeNode inv(TreeNode head) {
    if (head == null) {
      return head;
    }
    TreeNode right = inv(head.right);
    TreeNode left = inv(head.left);
    head.right = left;
    head.left = right;
    return head;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
