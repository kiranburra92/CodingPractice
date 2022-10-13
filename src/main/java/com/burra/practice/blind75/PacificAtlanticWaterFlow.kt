package com.burra.practice.blind75

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],
[3,2,3,4,4],
[2,4,5,3,1],
[6,7,1,4,5],
[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
[0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
[1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
[1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
[2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
[3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
[3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
[4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.


Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
 */
class PacificAtlanticWaterFlow {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        var pacific = Array(heights.size) { BooleanArray(heights[0].size) }
        var atlantic = Array(heights.size) { BooleanArray(heights[0].size) }
        var result = mutableListOf<List<Int>>()
        for (i in heights.indices) {
            for (j in heights[0].indices) {
                if (i == 0 || j == 0) {
                    dfs(i, j, heights.size - 1, heights[0].size - 1, pacific, heights, 0)
                }
                if (i == heights.size - 1 || j == heights[0].size - 1) {
                    dfs(i, j, heights.size - 1, heights[0].size - 1, atlantic, heights, 0)
                }
            }
        }

        for (i in heights.indices) {
            for (j in heights[0].indices) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }
        return result

    }

    private fun dfs(
        row: Int,
        col: Int,
        rows: Int,
        cols: Int,
        visited: Array<BooleanArray>,
        heights: Array<IntArray>,
        prevHeight: Int
    ) {
        if (row < 0 || col < 0 || row > rows || col > cols)
            return
        if (heights[row][col] < prevHeight || visited[row][col])
            return
        visited[row][col] = true
        dfs(row - 1, col, rows, cols, visited, heights, heights[row][col])
        dfs(row, col - 1, rows, cols, visited, heights, heights[row][col])
        dfs(row, col + 1, rows, cols, visited, heights, heights[row][col])
        dfs(row + 1, col, rows, cols, visited, heights, heights[row][col])
    }
}