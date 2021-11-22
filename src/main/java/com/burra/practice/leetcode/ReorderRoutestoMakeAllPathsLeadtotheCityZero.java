package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two
 * different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one
 * direction because they are too narrow.
 * <p>
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * <p>
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * <p>
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of
 * edges changed.
 * <p>
 * It's guaranteed that each city can reach city 0 after reorder.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]] Output: 3 Explanation: Change the direction of edges show
 * in red such that each node can reach the node 0 (capital).
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]] Output: 2 Explanation: Change the direction of edges show in
 * red such that each node can reach the node 0 (capital).
 * <p>
 * Example 3:
 * <p>
 * Input: n = 3, connections = [[1,0],[2,0]] Output: 0
 */
public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

  public int minReorder(int n, int[][] connections) {
    int ans = 0;
    boolean[] visit = new boolean[n];
    Map<Integer, Set<Integer>> tree = new HashMap<>();
    Set<String> edges = new HashSet<>();
    for (int[] c : connections) {
      int from = c[0];
      int to = c[1];
      tree.computeIfAbsent(from, k -> new HashSet<>());
      tree.computeIfAbsent(to, k -> new HashSet<>());
      tree.get(from).add(to);
      tree.get(to).add(from);
      edges.add(new StringBuilder().append(from).append("->").append(to).toString());
    }

    Queue<Integer> myQ = new LinkedList<>();
    myQ.add(0);

    while (!myQ.isEmpty()) {
      int node = myQ.poll();
      visit[node] = true;
      for (int neighbours : tree.get(node)) {
        if (visit[neighbours]) {
          continue;
        }
        if (!edges.contains(new StringBuilder().append(neighbours).append("->").append(node).toString())) {
          ans++;
        }
        myQ.add(neighbours);
      }
    }
    return ans;
  }
}
