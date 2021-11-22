package com.burra.practice.crackingCodingInterview.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

// Find if path existing between two nodes in a graph
public class RouteBetweenNodes {

  public boolean ifRouteExists(GraphNode g1, GraphNode g2) {
    Queue<GraphNode> q = new LinkedList<>();
    g1.isVisted = true;
    q.add(g1);
    q.add(null);

    GraphNode temp;
    while (!q.isEmpty()) {
      temp = q.remove();

      while (temp != null) {
        for (GraphNode adj : temp.adjList) {
          if (adj.val == g2.val) {
            return true;
          }
          if (!adj.isVisted) {
            adj.isVisted = true;
            q.add(adj);
          }
        }
        temp = q.remove();
      }
      q.add(null);
    }
    return false;
  }
}
