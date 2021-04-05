package com.burra.practice.leetcode;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

public class DuplicateElementsInArray {
    public List<Integer> findDuplicates(int[] nums) {
//        Map<Integer, Integer> m = new HashMap<>();
//        for(int i : nums){
//            m.put(i, m.getOrDefault(i, 0)+1);
//        }
//        return m.entrySet().stream().filter(map -> map.getValue() > 1).map(k -> k.getKey()).collect(Collectors.toList());

        // or

        int[] fre = new int[nums.length + 1];
        for( int i : nums) {
            fre[i]++;
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<fre.length;i++){
            if(fre[i]>1)
                l.add(i);
        }
        return l;

    }
}
