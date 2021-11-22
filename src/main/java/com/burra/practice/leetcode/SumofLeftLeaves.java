package com.burra.practice.leetcode;

public class SumofLeftLeaves {

  static boolean isLeaf(TreeNode node) {
    if (node == null) {
      return false;
    }
    if (node.left == null && node.right == null) {
      return true;
    }
    return false;
  }

  public static int sumOfLeftLeaves(TreeNode node) {
    int res = 0;

    if (node != null) {
      if (isLeaf(node.left)) {
        res += node.left.val;
      } else {
        res += sumOfLeftLeaves(node.left);
      }

      res += sumOfLeftLeaves(node.right);
    }

    return res;
  }

  public static void main(String... args) {
    TreeNode left3 = new TreeNode(3);
    TreeNode leaf4 = new TreeNode(4);
    TreeNode leaf5 = new TreeNode(5);
    TreeNode leaf2 = new TreeNode(2, leaf4, leaf5);
    TreeNode head = new TreeNode(1, leaf2, left3);
    System.out.println(sumOfLeftLeaves(head));
  }
}


