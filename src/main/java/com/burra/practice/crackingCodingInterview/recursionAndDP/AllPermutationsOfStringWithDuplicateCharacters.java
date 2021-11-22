package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPermutationsOfStringWithDuplicateCharacters {

  public List<String> getAllPerms(String str) {
    List<String> allPerms = new ArrayList<>();
    Map<Character, Integer> countTable = buildCountTable(str);
    getAllPermsHelper("", str.length(), allPerms, countTable);
    return allPerms;
  }

  private void getAllPermsHelper(String prefix, int remaining, List<String> allPerms,
      Map<Character, Integer> countTable) {
    if (remaining == 0) {
      allPerms.add(prefix);
      return;
    }
    for (Character c : countTable.keySet()) {
      int count = countTable.get(c);
      if (count > 0) {
        countTable.put(c, count - 1);
        getAllPermsHelper(prefix + c, remaining - 1, allPerms, countTable);
        countTable.put(c, count);
      }
    }
  }

  private Map<Character, Integer> buildCountTable(String str) {
    Map<Character, Integer> countTable = new HashMap<>();
    for (char c : str.toCharArray()) {
      countTable.put(c, countTable.getOrDefault(c, 0) + 1);
    }
    return countTable;
  }
}
