package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the
 * most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary,
 * which is 13.
 * <p>
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 * <p>
 * Return the sum of these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,1,0,1,0,1] Output: 22 Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */
public class SumofRootToLeafBinaryNumbers {

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    List<String> path = new ArrayList<>();
    return 0;
  }

  public void eachPath(TreeNode root) {

  }
}
