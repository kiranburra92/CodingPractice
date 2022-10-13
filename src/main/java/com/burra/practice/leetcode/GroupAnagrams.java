package com.burra.practice.leetcode;

import java.util.*;

/**
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      String count = chartCountToString(s);
      if (!map.containsKey(count)) {
        map.put(count, new ArrayList<String>());
      }
      map.get(count).add(s);

    }
    return new ArrayList(map.values());
  }

  public String chartCountToString(String s) {
    int[] nums = new int[26];
    Arrays.fill(nums, 0);
    for (char c : s.toCharArray()) {
      nums[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < nums.length; i++) {
      sb.append('#');
      sb.append(nums[i]);
    }
    return sb.toString();
  }
}
