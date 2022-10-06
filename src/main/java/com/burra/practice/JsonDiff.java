package com.burra.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDiff {

  public static void main(String[] args) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    map.computeIfAbsent(1, integer -> new ArrayList<>());
  }

}
