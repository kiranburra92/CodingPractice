package com.burra.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Number becomes 1 after following operations is a happy number.
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        n = Math.abs(n);
        Set<Integer> set = new HashSet<>();
        while(sqrt(n) != 1){
            n = sqrt(n);
            if(!set.add(n)) return false;
        }
        return true;
    }
    private static int sqrt(int n){
        int sum =0;
        while(n != 0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
    public static void main(String...args){
        isHappy(2);
    }
}
