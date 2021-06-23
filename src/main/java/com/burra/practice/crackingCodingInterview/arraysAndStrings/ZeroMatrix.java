package com.burra.practice.crackingCodingInterview.arraysAndStrings;

public class ZeroMatrix {
    void setZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for(int i = 0 ; i< matrix.length;i++){
            for (int j = 0 ; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0 ; i < row.length ; i++) {
            if(row[i])
                nullifyRow(matrix, i);
        }

        for(int i = 0 ; i < col.length ; i++) {
            if(col[i])
                nullifyCol(matrix, i);
        }
    }

    private void nullifyCol(int[][] matrix, int j) {
        for (int i = 0 ; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int i) {
        for (int j = 0 ; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
}
