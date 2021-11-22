package com.burra.practice.crackingCodingInterview.treesAndGraphs;

public class FirstCommonAncestorTree {

  // If the nodes have link to parents
  public TreeNode ancestorWithLinkToParent(TreeNode n1, TreeNode n2) {
    int firstDepth = getDepth(n1);
    int secondDepth = getDepth(n2);
    TreeNode small = firstDepth < secondDepth ? n1 : n2;
    TreeNode big = firstDepth < secondDepth ? n2 : n1;
    big = goUpByDiff(big, Math.abs(firstDepth - secondDepth));

    while (small != big && small != null && big != null) {
      small = small.parent;
      big = big.parent;
    }
      if (small == big) {
          return small;
      }
    return null;
  }

  private TreeNode goUpByDiff(TreeNode big, int abs) {
    while (abs-- > 0 && big != null) {
      big = big.parent;
    }
    return big;
  }

  private int getDepth(TreeNode node) {
    int count = 0;
    while (node.parent != null) {
      node = node.parent;
      count++;
    }
    return count;
  }

  public TreeNode ancestorWithOutLinkToParent(TreeNode root, TreeNode first, TreeNode second) {
      if (!covers(root, first) || !covers(root, second)) {
          return null;
      }
    return ancestorWithOutLinkToParentHelper(root, first, second);
  }

  private TreeNode ancestorWithOutLinkToParentHelper(TreeNode root, TreeNode first, TreeNode second) {
    boolean firstIsLeft = covers(root.left, first);
    boolean secondIsLeft = covers(root.right, second);
      if (firstIsLeft != secondIsLeft) {
          return root;
      }
    return firstIsLeft ? ancestorWithOutLinkToParentHelper(root.left, first, second) :
        ancestorWithOutLinkToParentHelper(root.right, first, second);
  }

  private boolean covers(TreeNode root, TreeNode node) {
      if (root == null) {
          return false;
      }
      if (root == node) {
          return true;
      }
    return covers(root.left, node) || covers(root.right, node);
  }
}
