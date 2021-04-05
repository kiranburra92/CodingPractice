package com.burra.practice.leetcode;

public class SumofTwoIntegersWithNoOperators {
    public int getSum(int a, int b) {
        while (b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String args[]) {
        int a = 10;
        int b = 9;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(10 & 9));
    }
}
