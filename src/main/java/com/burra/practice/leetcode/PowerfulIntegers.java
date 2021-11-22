package com.burra.practice.leetcode;

import java.util.List;

/**
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal
 * to bound.
 * <p>
 * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
 * <p>
 * You may return the answer in any order. In your answer, each value should occur at most once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2, y = 3, bound = 10 Output: [2,3,4,5,7,9,10] Explanation: 2 = 2^0 + 3^0 3 = 2^1 + 3^0 4 = 2^0 + 3^1 5 =
 * 2^1 + 3^1 7 = 2^2 + 3^1 9 = 2^3 + 3^0 10 = 2^0 + 3^2
 * <p>
 * Example 2:
 * <p>
 * Input: x = 3, y = 5, bound = 15 Output: [2,4,6,8,10,14]
 */
public class PowerfulIntegers {

  public List<Integer> powerfulIntegers(int x, int y, int bound) {
//        Set<Integer> set = new HashSet<>();
//        List<Double> xs = new ArrayList<>();
//        List<Double> ys = new ArrayList<>();
//        for(int i= 0; i< bound; i++){
//            xs.add(Math.pow(x,i));
//            ys.add(Math.pow(y,i));
//        }
//        for (Double d1 : xs) {
//            for (Double d2 : ys) {
//                if(d1+ d2 <= bound)
//                    set.add(d1.intValue() + d2.intValue());
//            }
//        }
//        return set.stream().collect(Collectors.toList());
    return null;
  }
}
