package com.burra.practice.crackingCodingInterview.treesAndGraphs;

//Given two very large trees, check if a tree is subtree of other.
public class checkIsSubTree {

    // Inorder travel each tree to form strings and check if one tree is substring of other tree's string
    // O(m + n)
    public boolean checkSubtree1(TreeNode n1, TreeNode n2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        getStringFromTree(n1, s1);
        getStringFromTree(n2, s2);

        return s1.indexOf(s2.toString()) > -1 ? true : false;
    }

    private void getStringFromTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('x');
            return;
        }
        sb.append(root.val);
        getStringFromTree(root.left, sb);
        getStringFromTree(root.right, sb);
    }

    // O(log(n) + log(m))
    public boolean checkSubTree2(TreeNode n1, TreeNode n2) {
        if (n2 == null) return true;

        return subTree(n1, n2);
    }

    private boolean subTree(TreeNode n1, TreeNode n2) {
        if (n1 == null) return false;

        else if (n1.val == n2.val && matchTree(n1, n2)) return true;

        return subTree(n1.left, n2) || subTree(n1.right, n2);
    }

    private boolean matchTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;

        else if (n1 == null || n2 == null) return false;

        else if (n1.val != n2.val) return false;

        return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);
    }
}
