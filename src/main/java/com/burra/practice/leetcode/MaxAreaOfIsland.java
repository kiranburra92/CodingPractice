package com.burra.practice.leetcode;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]] Output: 6 Explanation: The answer is not 11, because the island must be connected
 * 4-directionally. Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]] Output: 0
 */
public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    boolean[][] seen = new boolean[grid.length][grid[0].length];
    return maxAreaOfIslandHelper(grid, seen);
  }

  int maxAreaOfIslandHelper(int[][] grid, boolean[][] seen) {
    int max = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        max = Math.max(maxArea(grid, seen, i, j), max);
      }
    }
    return max;
  }

  int maxArea(int[][] grid, boolean[][] seen, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || seen[i][j] || grid[i][j] == 0) {
      return 0;
    }
    seen[i][j] = true;

    return (1 + maxArea(grid, seen, i - 1, j) +
        maxArea(grid, seen, i + 1, j) +
        maxArea(grid, seen, i, j + 1) +
        maxArea(grid, seen, i, j - 1));
  }
}
