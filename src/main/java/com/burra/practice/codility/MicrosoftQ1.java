package com.burra.practice.codility;

import java.util.HashSet;
import java.util.Set;

public class MicrosoftQ1 {

    public static int[] solution(int N){
        Set<Integer> set = new HashSet<>();
        int a = N%2;
        int b = N/2;
        for(int i = 0; i< b ;i++){
            if(!set.contains(b-i))
                set.add(-(b-i));
        }
        if(a !=0)
            set.add(0);
        for(int i = 0; i< b ;i++){
            if(!set.contains(b-i))
                set.add(b-i);
        }
        int[] array = new int[set.size()];
        int k = 0;
        for(Integer i: set){
            array[k++] = i;
        }
        return array;
    }
}
