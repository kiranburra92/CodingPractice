package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList = new ArrayList<>();
        List<Integer> prevList = null;
        List<Integer> currList;
        if(numRows != 0) {
            prevList = new ArrayList<Integer>();
            prevList.add(1);
            pascalList.add(prevList);
        }
        for(int i = 2;i<=numRows;i++){
            currList = new ArrayList<>(i);
            currList.add(0, 1);
            for(int j = 1; j <= i-2; j++){
                currList.add(j, prevList.get(j-1) + prevList.get(j));
            }
            currList.add(currList.size(), 1);
            pascalList.add(currList);
            prevList = currList;
        }
        return pascalList;
    }

    public static void main(String args[]){
        generate(3);
    }
}
