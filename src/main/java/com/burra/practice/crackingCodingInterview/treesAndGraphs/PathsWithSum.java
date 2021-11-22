package com.burra.practice.crackingCodingInterview.treesAndGraphs;

// Find number of path exist from each node that sum to target value
public class PathsWithSum {

  // O(n log(n)) - balanced tree
  // O(n^2) - unbalanced tree
  public int countPathSum1(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int totalPath = countPathSumFromNode(root, targetSum, 0);
    totalPath += countPathSum1(root.left, targetSum);
    totalPath += countPathSum1(root.right, targetSum);
    return totalPath;
  }

  private int countPathSumFromNode(TreeNode node, int targetSum, int currentSum) {
    if (node == null) {
      return 0;
    }
    int total = 0;
    currentSum += node.val;
    if (currentSum == targetSum) {
      total++;
    }
    total += countPathSumFromNode(node.left, targetSum, currentSum);
    total += countPathSumFromNode(node.right, targetSum, currentSum);
    return total;
  }


}
