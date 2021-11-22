package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.ArrayList;
import java.util.List;

// Return all permutations of a string with unique characters
public class AllPermutationsOfStringWithUniqueCharacters {

  List<String> getAllPermutations(String str) {
    if (str == null) {
      return null;
    }
    List<String> allPerms = new ArrayList<>();
    if (str.length() == 0) {
      allPerms.add("");
      return allPerms;
    }
    char first = str.charAt(0);
    String remaining = str.substring(1);
    List<String> words = getAllPermutations(remaining);
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        allPerms.add(insertChartAti(word, i, first));
      }
    }
    return allPerms;
  }

  private String insertChartAti(String word, int i, char first) {
    return word.substring(0, i) + first + word.substring(i);
  }
}
