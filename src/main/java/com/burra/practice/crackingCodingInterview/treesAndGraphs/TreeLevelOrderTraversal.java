package com.burra.practice.crackingCodingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Return a List of all elements at each level in a tree
public class TreeLevelOrderTraversal {

  public List<List<TreeNode>> levelOrderTraversal(TreeNode root) {
    List<List<TreeNode>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      TreeNode temp = q.remove();
      List<TreeNode> subResult = new ArrayList<>();
      while (temp != null) {
        subResult.add(temp);
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
        temp = q.remove();
      }
      result.add(subResult);
      if (!q.isEmpty()) {
        q.add(null);
      }
    }
    return result;
  }
}
