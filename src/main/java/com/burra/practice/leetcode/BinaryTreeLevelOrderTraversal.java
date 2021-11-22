package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> mylist = new ArrayList<>();

    if (root == null) {
      return mylist;
    }
    Queue<TreeNode> myQ = new LinkedList<>();
    myQ.add(root);
    myQ.add(null);
    while (!myQ.isEmpty()) {
      TreeNode tempRoot = myQ.remove();
      List<Integer> sublist = new ArrayList<>();
      while (tempRoot != null) {
        sublist.add(tempRoot.val);
        if (tempRoot.left != null) {
          myQ.add(tempRoot.left);
        }
        if (tempRoot.right != null) {
          myQ.add(tempRoot.right);
        }
        tempRoot = myQ.remove();
      }

      mylist.add(sublist);
      if (myQ.size() != 0) {
        myQ.add(null);
      }
    }
    // to get the bottom first list
    // Collections.reverse(myList);
    return mylist;
  }

  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
