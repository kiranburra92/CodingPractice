package com.burra.practice.leetcode;

public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        for (; i < n; i++) {
            if (nums[i] == nums[i + 1]) {
                n--;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 3};
        int i = removeDuplicates(a);
        for (int p = 0; p < i; p++) {
            System.out.println(a[p]);
        }
    }
}
