package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingArray {
    public boolean checkPossibility(int... nums){
        int count = 0;
        for(int i=0; i< nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                if(i >0){
                    if(nums[i-1] < nums[i+1]){
                        nums[i] = nums[i-1];
                    }
                    else{
                        nums[i+1] = nums[i];
                    }
                }
                count++;
            }
        }
        return (count <=1);
    }

    public static void main(String args[]) {
        NonDecreasingArray object = new NonDecreasingArray();
        System.out.println("should be false: "+ object.checkPossibility(3,4,2,3));
        System.out.println("should be true: "+object.checkPossibility(4, 2, 3));
        System.out.println("should be true: "+object.checkPossibility(2,2,3,2,4));
    }
}
