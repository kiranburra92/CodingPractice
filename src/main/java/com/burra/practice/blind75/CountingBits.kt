package com.burra.practice.blind75

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of
 * 1's in the binary representation of i.



Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */
class CountingBits {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1)
        for(i in 0..n){
            result[i] = countOnes(i, result)
        }
        return result
    }

    private fun countOnes(i: Int, result: IntArray): Int {
        if(i == 0)
            return 0
        if(i == 1)
            return 1
        if(result[i] > 0)
            return result[i]

        // power of 2 will have only 1 bit, odd numbers have 1 + bits(n/2)
        result[i] = if(i%2 == 0)
            countOnes(i/2, result)
        else
            1 + countOnes(i/2, result)
        return result[i]
    }
}