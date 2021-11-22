package com.burra.practice.leetcode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low,
 * high].
 */
public class RangeSumofBST {

  int sum = 0;

  public int rangeSumBST(TreeNode root, int low, int high) {
    dfs(root, low, high);
    return sum;
  }

  public void dfs(TreeNode root, int low, int high) {
    if (root != null) {
      if (root.val >= low && root.val <= high) {
        sum += root.val;
      }
      if (low < root.val) {
        rangeSumBST(root.left, low, high);
      }
      if (high > root.val) {
        rangeSumBST(root.right, low, high);
      }
    }
  }
}
