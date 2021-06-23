package com.burra.practice.leetcode;

public class ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return null;
        TreeNode root = new TreeNode(nums[length / 2]);
        root.left = sortedArrayToBst(nums, 0, length / 2 - 1);
        root.right = sortedArrayToBst(nums, length / 2 + 1, length-1);
        return root;
    }

    public TreeNode sortedArrayToBst(int[] nums, int lower, int upper) {
        TreeNode node = null;
        if (lower > upper)
            return null;
        node = new TreeNode(nums[(lower + upper) / 2]);
        node.left = sortedArrayToBst(nums, lower, (upper + lower) / 2 - 1);
        node.right = sortedArrayToBst(nums, (upper + lower) / 2 + 1, upper);

        return node;
    }

    public static void main(String... args) {
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();
        int[] nums = { -10, -3, 0, 5, 9 };
        convertSortedArraytoBinarySearchTree.sortedArrayToBST(nums);
    }
}
