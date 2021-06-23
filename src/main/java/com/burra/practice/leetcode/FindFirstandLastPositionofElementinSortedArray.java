package com.burra.practice.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given
 * target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1};
        int start1 = 0;
        int end1 = nums.length -1;

        int start2 = 0;
        int end2 = nums.length -1;

        boolean temp = false;
        while (start1 <= end1) {
            int mid = (end1+start1)/2;
            if(nums[mid] >= target){
                end1 = mid - 1;
            }
            else
                start1 = mid +1;
            if(nums[mid] == target)
                temp = true;
        }

        while (start2 <= end2) {
            int mid = (end2+start2)/2;
            if(nums[mid] <= target){
                start2 = mid + 1;
            }
            else
                end2 = mid -1;
            if(nums[mid] == target)
                temp = temp || true;
        }
        if(temp) {
            range[0] = start1;
            range[1] = end2;
        }

        return range;
    }

    public static void main(String[] args) {
        int[] n = {5,7,7,8,8,10};
        System.out.println(searchRange(n, 8));
    }
}
