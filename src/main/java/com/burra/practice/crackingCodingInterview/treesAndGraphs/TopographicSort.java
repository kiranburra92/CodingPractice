package com.burra.practice.crackingCodingInterview.treesAndGraphs;

import java.util.*;

public class TopographicSort {

  public GraphNode[] sort(int[] array, int[][] dependencies) {
    List<GraphNode> projects = new ArrayList<>();

    Graph g = new Graph();
    for (int i : array) {
      g.addNode(i);
    }
    for (int[] i : dependencies) {
      g.addEdge(i[0], i[1]);
    }
    Queue<GraphNode> q = new LinkedList<>();
    for (GraphNode n : g.allNodes.values()) {
      if (n.dependencies == 0) {
        q.add(n);
      }
    }
    while (!q.isEmpty()) {
      GraphNode tempNode = q.remove();
      projects.add(tempNode);
      for (GraphNode n : g.nodes) {
        if (n.adjList.contains(tempNode)) {
          n.dependencies--;
        }
      }
      for (GraphNode n : g.allNodes.values()) {
        if (n.dependencies == 0 && !projects.contains(n)) {
          q.add(n);
        }
      }
    }
    if (projects.size() == array.length) {
      return projects.stream().toArray(GraphNode[]::new);
    }
    return null;
  }

  class Graph {

    List<GraphNode> nodes = new ArrayList<>();
    Map<Integer, GraphNode> allNodes = new HashMap<>();

    void addNode(int val) {
      GraphNode temp = new GraphNode(val);
      allNodes.put(val, temp);
      nodes.add(temp);
    }

    // v2 depends on v1
    void addEdge(int v1, int v2) {
      allNodes.get(v1).adjList.add(allNodes.get(v2));
      allNodes.get(v2).dependencies++;
    }
  }
}
