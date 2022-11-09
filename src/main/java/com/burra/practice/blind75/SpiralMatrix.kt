package com.burra.practice.blind75

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:

Input: matrix =[[1,2,3],
                [4,5,6],
                [7,8,9]]

Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix =[[1,2,3,4],
                [5,6,7,8],
                [9,10,11,12]]

Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        var topLeft = 0
//        var topRight = matrix.size-1
//        var downRight = matrix[0].size-1
//        var downLeft = 0

        var result = mutableListOf<Int>()
//        while(result.size < matrix.size*matrix[0].size) {
//            for(j in 0..topRight){
//                result.add(matrix[topLeft][j])
//            }
//            topLeft++
//            for(i in topLeft .. downRight){
//                result.add(matrix[i][topRight])
//            }
//            downRight--
//            for(j in downRight downTo downLeft){
//                result.add(matrix[downRight][j])
//            }
//            downLeft
//
//        }
        return result

    }
}