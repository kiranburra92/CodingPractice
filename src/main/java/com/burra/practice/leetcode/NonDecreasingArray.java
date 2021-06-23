package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingArray {
    public boolean checkPossibility(int... nums){
        int flag = 0;
        int n = nums.length;

        for (int i =0 ; i<n-1;i++) {
            if(nums[i] > nums[i+1]) {
                flag++;
                if (i > 0 && (nums[i + 1] < nums[i - 1]))
                    nums[i + 1] = nums[i];
            }
            if(flag > 1)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        NonDecreasingArray object = new NonDecreasingArray();
        System.out.println("should be false: "+ object.checkPossibility(3,4,2,3));
        System.out.println("should be true: "+object.checkPossibility(4, 2, 3));
        System.out.println("should be true: "+object.checkPossibility(2,2,3,2,4));
    }
}
