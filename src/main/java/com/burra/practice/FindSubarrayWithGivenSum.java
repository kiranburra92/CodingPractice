package com.burra.practice;

public class FindSubarrayWithGivenSum {
    public static void printSubarray(int[] arr, int sum){
        int n = arr.length;
        int curr_sum = arr[0], start = 0, i = 0;
        while(i<n) {
            if(curr_sum > sum){
                curr_sum = curr_sum-arr[start];
                start ++;
            }

            if(curr_sum == sum){
                System.out.println(start + " " + i);
                return;
            }
            curr_sum = curr_sum+arr[i];
            i++;
        }

    }
    public static void main(String args[]) {
        int[] arr =  {15, 2, 4, 8, 9, 5, 10, 23};
        printSubarray(arr, 23);
    }
}
