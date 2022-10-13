package com.burra.practice.leetcode;

import java.util.*;

public class TopKFrequentElements {

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    //get the max frequency
    int max = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      max = Math.max(max, entry.getValue());
    }

    //initialize an array of ArrayList. index is frequency, value is list of numbers
    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max + 1];
    for (int i = 1; i <= max; i++) {
      arr[i] = new ArrayList<>();
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int count = entry.getValue();
      int number = entry.getKey();
      arr[count].add(number);
    }

    List<Integer> result = new ArrayList<>();

    //add most frequent numbers to result
    for (int j = max; j >= 1; j--) {
      if (!arr[j].isEmpty()) {
        for (int a : arr[j]) {
          result.add(a);
          //if size==k, stop
          if (result.size() == k) {
            return convtList(result);
          }
        }
      }
    }

    return convtList(result);
  }

  public static int[] convtList(List<Integer> l) {
    int[] a = new int[l.size()];
    int i = 0;
    for (Integer p : l) {
      a[i] = p;
      i++;
    }
    return a;
  }

  public static void main(String[] arg) {
    Arrays.stream(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).forEach(System.out::println);
  }
}
