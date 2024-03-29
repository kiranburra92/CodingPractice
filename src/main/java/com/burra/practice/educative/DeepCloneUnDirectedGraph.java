package com.burra.practice.educative;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node { public int val; public List<Node> neighbors; }
 * <p>
 * <p>
 * Test case format:
 * <p>
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val
 * == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 * <p>
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
 * neighbors of a node in the graph.
 * <p>
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference
 * to the cloned graph.
 * <p>
 * The number of nodes in the graph is in the range [0, 100]. 1 <= Node.val <= 100 Node.val is unique for each node.
 */
public class DeepCloneUnDirectedGraph {

  public Node clone(Node n) {
    Node[] nodes = new Node[101];
    return dfs(n, nodes);
  }

  private Node dfs(Node n, Node[] nodes) {
      if (n == null) {
          return null;
      }

    if (nodes[n.val] != null) {
      return nodes[n.val];
    }
    Node copy = new Node(n.val);
    nodes[copy.val] = copy;
    for (Node adj : n.neighbors) {
      copy.neighbors.add(dfs(adj, nodes));
    }
    return copy;
  }

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
