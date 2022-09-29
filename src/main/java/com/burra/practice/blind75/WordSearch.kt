package com.burra.practice.blind75

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */
class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (word[0] == board[i][j] && traverseMatrix(word, 0, i, j, visited, board)) return true
            }
        }
        return false
    }

    private fun traverseMatrix(
        word: String, index: Int, i: Int, j: Int, visited: Array<BooleanArray>, board: Array<CharArray>
    ): Boolean {

        if (index == word.length) return true
        if (i < 0 || j < 0 || i >= visited.size || j >= visited[0].size || visited[i][j] || index > word.length ||
            word[index] != board[i][j]
        ) return false

        visited[i][j] = true
        val result = traverseMatrix(word, index + 1, i + 1, j, visited, board) ||
                traverseMatrix(word, index + 1, i - 1, j, visited, board) ||
                traverseMatrix(word, index + 1, i, j + 1, visited, board) ||
                traverseMatrix(word, index + 1, i, j - 1, visited, board)
        visited[i][j] = false
        return result
    }
}