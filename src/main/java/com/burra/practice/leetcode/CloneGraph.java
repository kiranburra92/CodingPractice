package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

  List<Integer> visited = new ArrayList<>();
  Map<Integer, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {
      if (node == null) {
          return null;
      }
    Node cloneNode = new Node(node.val);
    visited.add(cloneNode.val);
    map.put(cloneNode.val, cloneNode);
    for (Node n : node.neighbors) {
      if (!visited.contains(n.val)) {
        cloneGraph(n);
      } else {
        cloneNode.neighbors.add(map.get(n.val));
      }
    }
    return cloneNode;
  }

  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
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
