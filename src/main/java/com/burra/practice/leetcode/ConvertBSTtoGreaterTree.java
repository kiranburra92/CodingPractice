package com.burra.practice.leetcode;

/**
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
 * changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node
 * contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary
 * search trees.
 * <p>
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8] Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [0,null,1] Output: [1,null,1]
 * <p>
 * Example 3:
 * <p>
 * Input: root = [1,0,2] Output: [3,3,2]
 * <p>
 * Example 4:
 * <p>
 * Input: root = [3,2,4,1] Output: [7,9,4,10]
 */
public class ConvertBSTtoGreaterTree {

  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root != null) {
      convertBST(root.right);
      sum += root.val;
      root.val = sum;
      convertBST(root.left);
    }
    return root;
  }
}
