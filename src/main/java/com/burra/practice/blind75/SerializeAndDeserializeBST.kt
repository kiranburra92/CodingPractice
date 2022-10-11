package com.burra.practice.blind75

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.



Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.
 */
class SerializeAndDeserializeBST {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun preOrderTraversal(root: TreeNode?, sb: StringBuilder) {
        if (root == null) {
            sb.append("n/")
            return
        }
        sb.append(root.`val`).append("/")
        preOrderTraversal(root.left, sb)
        preOrderTraversal(root.right, sb)
    }

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        var result = StringBuilder()
        preOrderTraversal(root, result)
        return result.toString()
    }

    private fun constructPreOrder(preOrder: List<String>, index: IntArray, size: Int): TreeNode? {
        if (index[0] > size)
            return null

        if (preOrder[index[0]] == "n") {
            index[0]++
            return null
        }
        var root = TreeNode(preOrder[index[0]].toInt())
        index[0]++
        root.left = constructPreOrder(preOrder, index, size)
        root.right = constructPreOrder(preOrder, index, size)
        return root
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var preOrder = data.split("/")
        return constructPreOrder(preOrder, intArrayOf(0), preOrder.size - 1)
    }
}