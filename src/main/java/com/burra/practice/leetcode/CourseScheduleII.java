package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1. Return the ordering of
 * courses you should take to finish all courses. If there are many valid answers, return any of them. If it is
 * impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: [0,1] Explanation: There are a total of 2 courses to take. To
 * take course 1 you should have finished course 0. So the correct course order is [0,1].
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] Output: [0,2,1,3] Explanation: There are a total of
 * 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be
 * taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * <p>
 * Example 3:
 * <p>
 * Input: numCourses = 1, prerequisites = [] Output: [0]
 */
public class CourseScheduleII {

  class Solution {

    /**
     * The first node in the topological ordering will be the node that doesn't have any incoming edges. Essentially,
     * any node that has an in-degree of 0 can start the topologically sorted order. If there are multiple such nodes,
     * their relative order doesn't matter and they can appear in any order.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

      boolean isPossible = true;
      Map<Integer, List<Integer>> adjList = new HashMap<>();
      int[] indegree = new int[numCourses];
      int[] topologicalOrder = new int[numCourses];

      // Create the adjacency list representation of the graph
      for (int i = 0; i < prerequisites.length; i++) {
        int dest = prerequisites[i][0];
        int src = prerequisites[i][1];
        List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
        lst.add(dest);
        adjList.put(src, lst);

        // Record in-degree of each vertex
        indegree[dest] += 1;
      }

      // Add all vertices with 0 in-degree to the queue
      Queue<Integer> q = new LinkedList<>();
      for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
          q.add(i);
        }
      }

      int i = 0;
      // Process until the Q becomes empty
      while (!q.isEmpty()) {
        int node = q.remove();
        topologicalOrder[i++] = node;

        // Reduce the in-degree of each neighbor by 1
        if (adjList.containsKey(node)) {
          for (Integer neighbor : adjList.get(node)) {
            indegree[neighbor]--;

            // If in-degree of a neighbor becomes 0, add it to the Q
            if (indegree[neighbor] == 0) {
              q.add(neighbor);
            }
          }
        }
      }

      // Check to see if topological sort is possible or not.
      if (i == numCourses) {
        return topologicalOrder;
      }

      return new int[0];
    }
  }
}
