package com.burra.practice.blind75

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the
 * values of the nodes in the tree.



Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 */
class KthSmallestElementinaBST {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val linkedList = mutableListOf<Int>()
        inOrder(root, linkedList)
        return linkedList[k-1]
    }

    private fun inOrder(root: TreeNode?, linkedList: MutableList<Int>) {
        if(root == null)
            return
        inOrder(root.left, linkedList)
        linkedList.add(root.`val`)
        inOrder(root.right, linkedList)
    }
}