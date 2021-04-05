package com.burra.practice.leetcode;


public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isValidBST(TreeNode root, double min, double max) {
        if(root==null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max );
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        ValidateBinarySearchTree.TreeNode right = v.new TreeNode(1);
        ValidateBinarySearchTree.TreeNode root = v.new TreeNode(1, null, right);
        System.out.println(v.isValidBST(root));


    }
}
