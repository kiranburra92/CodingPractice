package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
 * The first and last elements never change.
 *
 * return list of elements if non of the array elements changed.
 */
public class ArrayTransformation {
    public List<Integer> transformArray(int[] arr) {
        int[] myarr = Arrays.copyOfRange(arr, 0, arr.length);
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i = 1; i< arr.length-1 && flag;i++) {
                int prev  = arr[i-1];
                if(prev < arr[i] && arr[i+1] < arr[i]) {
                    flag = true;
                    arr[i]--;
                }
                else if(prev > arr[i] && arr[i+1] > arr[i]) {
                    flag = true;
                    arr[i]++;
                }
            }
        }
        return list;
    }
}
