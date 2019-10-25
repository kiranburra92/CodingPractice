package com.burra.practice.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mynums = Arrays.copyOf(nums1, nums1.length);
        int i = 0;
        int j = 0;
        int p = 0;

        while (i < m && j < n){
            if(mynums[i] <= nums2[j]){
                nums1[p++] = mynums[i++];
            }
            else if(j < n){
                nums1[p++] = nums2[j++];
            }
        }
        if(i >= m)
            while(j < n)
                nums1[p++] = nums2[j++];

        if(j >= n)
            while(i < m)
                nums1[p++] = mynums[i++];
    }
    public static void main(String...args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums4 = {0, 0 ,0};
        int[] nums5 = {2,5,6};
        merge(nums4,0, nums5, 3);
        System.out.println(Arrays.toString(nums4));
    }
}
