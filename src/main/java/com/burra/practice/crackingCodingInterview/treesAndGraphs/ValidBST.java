package com.burra.practice.crackingCodingInterview.treesAndGraphs;

public class ValidBST {

  public boolean isValid(TreeNode root) {
    return isValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isValidHelper(TreeNode root, int minValue, int maxValue) {
    if (root == null) {
      return true;
    }
    if (root.val > maxValue || root.val <= minValue) {
      return false;
    }
    return isValidHelper(root.left, minValue, root.val) && isValidHelper(root.right, root.val, maxValue);
  }
}
