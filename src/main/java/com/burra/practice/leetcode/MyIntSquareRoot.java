package com.burra.practice.leetcode;
import java.math.BigInteger;
public class MyIntSquareRoot {
    public static int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
        long x1 = x;
        long left = 0;
        long right = x1/2;
        long mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(mid*mid == x1 || (mid*mid <x1 && (mid+1)*(mid+1) > x1 ))
                return (int)mid;
            else if(mid*mid <x1)
                left = mid + 1;
            else
                right = mid -1;
        }
        return (int)mid;
    }
    public static void main(String...args){
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395600));
    }
}
