package com.burra.practice.crackingCodingInterview.treesAndGraphs;

import java.util.HashMap;
import java.util.Map;

// check if Binary is balanced that max difference between left and right subtree should be less than 1
public class CheckBTisBalanced {

  Map<TreeNode, Integer> heights = new HashMap<>();

  public boolean isBalanced(TreeNode root) {
      if (root == null) {
          return true;
      }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
  }

  private int getHeight(TreeNode root) {
      if (root == null) {
          return 0;
      }
      if (heights.containsKey(root)) {
          return heights.get(root);
      }
    int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    heights.put(root, height);
    return height;
  }
}
