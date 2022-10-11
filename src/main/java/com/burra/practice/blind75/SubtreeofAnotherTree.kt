package com.burra.practice.blind75

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
 * structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree
tree could also be considered as a subtree of itself.



Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false


Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
 */
class SubtreeofAnotherTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null)
            return true
        if (root == null)
            return false
        if ((subRoot.`val` == root.`val`) && matchTrees(root, subRoot)) {
            return true
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun matchTrees(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null)
            return true
        if (root == null || subRoot == null)
            return false
        if (root.`val` != subRoot.`val`)
            return false

        return matchTrees(root.left, subRoot.left) && matchTrees(root.right, subRoot.right)
    }
}