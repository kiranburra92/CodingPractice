package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

  int preorderIndex;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return buildTreeHelper(preorder, 0, preorder.length - 1, map);
  }

  private TreeNode buildTreeHelper(int[] preorder, int start, int end, Map<Integer, Integer> map) {
    if (start > end) {
      return null;
    }
    int val = preorder[preorderIndex++];
    TreeNode root = new TreeNode(val);
    int index = map.get(val);
    root.left = buildTreeHelper(preorder, start, index - 1, map);
    root.right = buildTreeHelper(preorder, index + 1, end, map);
    return root;
  }
}
