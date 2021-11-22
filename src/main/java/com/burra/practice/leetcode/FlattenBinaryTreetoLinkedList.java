package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the
 * list and the left child pointer is always null. The "linked list" should be in the same order as a pre-order
 * traversal of the binary tree.
 * <p>
 * Input: root = [1,2,5,3,4,null,6] Output: [1,null,2,null,3,null,4,null,5,null,6]
 */
public class FlattenBinaryTreetoLinkedList {

  public void flatten(TreeNode root) {
    List<TreeNode> order = new ArrayList<>();
    preOrder(root, order);
    for (int i = 0; i < order.size() - 1; i++) {
      TreeNode temp = order.get(i);
      temp.left = null;
      temp.right = order.get(i + 1);
    }
  }

  public void preOrder(TreeNode root, List<TreeNode> order) {
    if (root == null) {
      return;
    }
    order.add(root);
    preOrder(root.left, order);
    preOrder(root.right, order);
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
