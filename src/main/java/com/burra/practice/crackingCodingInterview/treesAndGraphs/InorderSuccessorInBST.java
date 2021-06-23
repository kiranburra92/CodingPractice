package com.burra.practice.crackingCodingInterview.treesAndGraphs;

// Return the successor of a given node in BST inorder traversal, assuming node has link to parent.
public class InorderSuccessorInBST {

    // if right != null return the left most child in right child else, travel to parent till node is left child
    public TreeNode successor(TreeNode n) {
        if(n == null) return null;

        if(n.right != null)
            return getLeftMostChild(n.right);
        TreeNode parent = n.parent;
        while (parent != null && parent.left != n){
            n = parent;
            parent = n.parent;
        }
        return parent;
    }

    private TreeNode getLeftMostChild(TreeNode n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
