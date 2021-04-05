package com.burra.practice.leetcode;

public class Searcha2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        if(matrix.length == 1)
            return findElement(matrix[0], target);
        if(matrix[0][0] > target || matrix[matrix.length-1][matrix[0].length -1] < target)
            return false;
        for (int i = matrix.length-1; i >= 1;i--) {
            if(matrix[i][matrix[0].length-1] >= target && matrix[i-1][matrix[0].length-1] < target){
                return findElement(matrix[i], target);
            }
            else if(i == 1){
                return findElement(matrix[0], target);
            }
        }
        return false;
    }
    private static boolean findElement(int[] m, int target) {
        int low = 0;
        int high = m.length-1;
        int mid = 0;
        while (low <= high){
            mid = (low+high)/2;
            if(m[mid] == target)
                return true;
            if(m[mid] > target)
                high = mid-1;
            else
                low = mid +1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1},{3}}, 1));
    }
}
