package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * Example 2:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(graph, vis, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * All the nodes are initially white showing that none of the nodes are yet travelled. As we arrived at the certain
     * node we change its color to Gray which will remain Gray until all its descendant is explored. As soon as the
     * descendant gets explored we change its color to Black which denotes that it is now completely traveled.
     * <p>
     * Now while exploring the neighbors the node if any of its neighbors color is gray it confirms the back edge in
     * the graph and proofs there is a cycle..
     */
    public boolean dfs(ArrayList<Integer>[] graph, int[] vis, int src) {
        vis[src] = 1;
        for (int nbr : graph[src]) {
            if (vis[nbr] == 1) {
                return false;
            } else if (vis[nbr] == 0) {
                if (!dfs(graph, vis, nbr))
                    return false;
            }
        }
        vis[src] = 2;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int[][] a = {{1, 0}};
        System.out.println(c.canFinish(2, a));
    }
}
