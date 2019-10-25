package com.burra.practice.leetcode;
/**
 * Determine if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given sum.
 */
public class ElementsInTreePathWithSum {
    public boolean hasPathSum(ConvertSortedArraytoBinarySearchTree.TreeNode root, int sum) {
        if(root == null)
            return false;
        return hasPathSumUtil(root, sum);
    }
    public boolean hasPathSumUtil(ConvertSortedArraytoBinarySearchTree.TreeNode root, int sum){
        if(root == null)
            return sum==0;
        else {
            boolean ans = false;
            int subSum = sum - root.val;
            if(subSum == 0 && root.left == null && root.right == null)
                return true;
            if(root.right != null)
                ans = ans || hasPathSumUtil(root.right, subSum);
            if(root.left != null)
                ans = ans || hasPathSumUtil(root.left, subSum);
            return ans;
        }
    }
}
