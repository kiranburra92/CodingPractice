package com.burra.practice.blind75

import java.util.LinkedList
import java.util.Queue

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

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
            var result = ""
        serialize(root, result)
        return result
//        var result = ""
//        if(root == null)
//            return result
//        var que: Queue<TreeNode> = LinkedList()
//
//        que.add(root)
//        while (que.isNotEmpty()) {
//            var temp = que.poll()
//            if(temp == null) {
//                result = result.plus(" ")
//                continue
//            }
//            result  = result.plus(temp.`val`)
//            que.add(temp.left)
//            que.add(temp.right)
//        }
//        return result
    }

    private fun serialize(root: TreeNode?, result: String) {
        if(root == null){
            return
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if(data.isBlank())
            return null

    }
}