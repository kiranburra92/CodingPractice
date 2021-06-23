package com.burra.practice.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class FriendCircleQueries {
    static int[] maxCircle(int[][] queries) {
        int[] result = new int[queries.length];
//        int count = 0;
//        List<List<Integer>> values = new ArrayList<>();
//        for(int[] i : queries){
//            boolean flag = false;
//            for(List<Integer> v : values){
//                flag = foundQueryInList(v, i);
//            }
//            if(!flag){
//                List<Integer> temp = new ArrayList<>();
//                temp.add(i[0]);
//                temp.add(i[1]);
//                values.add(temp);
//            }
//            result[count] = largestOfList(values);
//            count++;
//        }
        return result;
    }
    private static boolean foundQueryInList(List<Integer> value, int[] q) {
        boolean f = false;
        if(value.contains(q[0]) && ! value.contains(q[1])) {
            f = true;
            value.add(q[0]);
        }
        if(value.contains(q[1]) && ! value.contains(q[0])) {
            f = true;
            value.add(q[1]);
        }
        if(value.contains(q[1]) && value.contains(q[0])) {
            return f;
        }
        return f;
    }
    private static int largestOfList(List<List<Integer>> values) {
        int total = Integer.MIN_VALUE;
        for(List<Integer> l : values) {
            if(total < l.size())
                total = l.size();
        }
        return total;
    }
}
