package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.ArrayList;
import java.util.List;

// Return the power set of a given list
public class PowerSet {

  List<List<Integer>> getAllSubSets(List<Integer> set) {
    List<List<Integer>> allSubSets = new ArrayList<>();
    int max = 1 << set.size(); // 2^n subsets
    for (int i = 0; i < max; i++) {
      List<Integer> subSet = new ArrayList<>();
      int count = 0;
      for (int j = i; j > 0; j >>= 1) {
        if ((j & 1) == 1) {
          subSet.add(set.get(count));
        }
        count++;
      }
      allSubSets.add(subSet);
    }
    return allSubSets;
  }
}
