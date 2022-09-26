package com.burra.practice.blind75

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down
 * or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val memory = Array(m+1) {IntArray(n+1)}
        return uniquePaths(m, n, memory)
    }

    fun uniquePaths(m: Int, n: Int, memory: Array<IntArray>): Int {
        if(1 > m || 1 > n)
            return 0
        if(1 == m && 1 == n)
            return 1
        if(memory[m][n] != 0) {
            return memory[m][n]
        }

        memory[m][n] = uniquePaths(m-1, n, memory) + uniquePaths(m, n-1, memory)
        return memory[m][n]
    }
}

fun main() {
    val uniquePaths = UniquePaths()
    uniquePaths.uniquePaths(3, 7)
}