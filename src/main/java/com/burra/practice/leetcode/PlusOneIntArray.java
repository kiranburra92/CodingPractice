package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOneIntArray {
    public static int[] plusOne(int... digits) {
        List<Integer> my = new ArrayList<>();
        int carry = 1;
        int temp;
        for(int i= digits.length -1;i>=0;i--){
            temp = digits[i]+carry;
            carry = temp/10;
            my.add(temp%10);
        }
        if(carry != 0)
            my.add(carry);
        Collections.reverse(my);

        int[] arr = new int[my.size()];
        int p = 0;
        for(Integer j:my){
            arr[p] = j;
            p++;
        }
        return arr;
    }
    public static void main(String... args){
        System.out.println(Arrays.toString(plusOne(1,2,3)));
        System.out.println(Arrays.toString(plusOne(4,3,2,1)));
        System.out.println(Arrays.toString(plusOne(9)));
    }
}
