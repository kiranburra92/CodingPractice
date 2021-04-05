package com.burra.practice.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MicrosoftQ1 {
    static void sum_up_recursive(int[] numbers, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == 1)
            System.out.println("sum("+ Arrays.toString(partial.toArray())+")= 1");
        if (s >= 1)
            return;
        for(int i=0;i<numbers.length;i++) {
            int[] rem = new int[numbers.length - i];
            int n = numbers[i];
            for (int j=i+1; j<numbers.length;j++)
                rem[j]= numbers[j];
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(rem,partial_rec);
        }
    }
    static void sum_up(int[] numbers) {
        sum_up_recursive(numbers,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        int[] numbers = {3,9,8,4,5,7,10};
        int target = 15;
        sum_up(numbers);
    }
}

