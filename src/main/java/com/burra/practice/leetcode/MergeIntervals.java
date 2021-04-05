package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
//        boolean[] arr = new boolean[10002];
//        Arrays.fill(arr, false);
//        for (int[] i : intervals) {
//            Arrays.fill(arr, i[0], i[1], true);
//        }
//        List<int[]> res = new ArrayList<>();
//        boolean start = true;
//        int p = 0;
//        for(int i = 0;i<arr.length;i++){
//            if(arr[i] && start){
//                p = i;
//                start = false;
//            }
//            if(!arr[i] && !start){
//                res.add(new int[]{p, i-1});
//                start = true;
//            }
//        }
//        return res.toArray(new int[0][]);
        return null;
    }

    public static void main(String... args){
        System.out.println(merge(new int[][]{{1,4},{0,0}}));
    }
}
