package com.burra.practice.crackingCodingInterview.treesAndGraphs;

// Create a minimal high BST from the sorted array with unique integers
public class MinimalHighBSTWithSortedArray {

  public TreeNode createBST(int[] array) {
    return createBSTHelper(array, 0, array.length);
  }

  private TreeNode createBSTHelper(int[] array, int min, int max) {
    if (min > max) {
      return null;
    }
    int mid = min + (max - min) / 2;
    TreeNode root = new TreeNode();
    root.val = array[mid];
    root.left = createBSTHelper(array, 0, mid - 1);
    root.right = createBSTHelper(array, mid + 1, max);
    return root;
  }
}
