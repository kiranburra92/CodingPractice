package com.burra.practice.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 * Example 1:
 *
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        /**
         * The robot can only move either down or right. Hence any cell in the first row can only be reached from the cell left to it.
         * And, any cell in the first column can only be reached from the cell above it.
         * For any other cell in the grid, we can reach it either from the cell to left of it or the cell above it.
         * If any cell has an obstacle, we won't let that cell contribute to any path.
         */
        int m = grid.length;
        int n = grid[0].length;
        /**
         * If the first cell i.e. obstacleGrid[0,0] contains 1, this means there is an obstacle in the first cell.
         * Hence the robot won't be able to make any move and we would return the number of ways as 0.
         */
        if(grid[0][0] != 1) {
            grid[0][0] = 1;
        }
        else {
            return 0;
        }

        /**
         * Iterate the first column. If a cell originally contains a 1, this means the current cell has an obstacle and
         * shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
         * previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]
         */
        for(int i = 1; i < m;i++){
            if(grid[i][0] != 1){
                grid[i][0] = grid[i-1][0];
            }
            else{
                grid[i][0] = 0;
            }
        }

        /**
         * Iterate the first row. If a cell originally contains a 1, this means the current cell has an obstacle and
         * shouldn't contribute to any path. Hence, set the value of that cell to 0. Otherwise, set it to the value of
         * previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]
         */
        for(int i = 1; i<n;i++){
            if(grid[0][i] != 1){
                grid[0][i] = grid[0][i-1];
            }
            else{
                grid[0][i] = 0;
            }
        }

        /**
         * Now, iterate through the array starting from cell obstacleGrid[1,1]. If a cell originally doesn't contain any
         * obstacle then the number of ways of reaching that cell would be the sum of number of ways of reaching the
         * cell above it and number of ways of reaching the cell to the left of it.
         * obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]
         *
         * If a cell contains an obstacle set it to 0 and continue. This is done to make sure it doesn't contribute to
         * any other path.
         */
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j< n ; j++) {
                if(grid[i][j] != 1) {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
                else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid[m-1][n-1];
    }
}
