package com.burra.practice.leetcode;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and
 * lower right corner (row2, col2).
 * Implement the NumMatrix class:
 *
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]],
 * [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 *
 * Output
 * [null, 8, 11, 12]
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12
 */
public class RangeSumQuery2DImmutable {
    int[][] memory;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        memory = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0 ; i< matrix.length ; i++) {
            for(int j = 0 ; j< matrix[0].length; j++) {
                memory[i+1][j+1] = memory[i][j+1] + memory[i+1][j] + matrix[i][j] - memory[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return memory[row2+1][col2+1] - memory[row1][col2+1] - memory[row2+1][col1] + memory[row1][col1];
    }
}
