package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.HashSet;
import java.util.Set;

// Generate all valid parentheses for a int n
public class GenerateValidParentheses {

  Set<String> generateParentheses(int remaining) {
    Set<String> set = new HashSet<>();
    if (remaining == 0) {
      set.add("");
    } else {
      Set<String> prev = generateParentheses(remaining - 1);
      for (String str : prev) {
        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) == '(') {
            set.add(insertParenthesisAti(str, i));
          }
        }
        set.add("()" + str);
      }
    }
    return set;
  }

  private String insertParenthesisAti(String str, int i) {
    return str.substring(0, i + 1) + "()" + str.substring(i + 1);
  }
}
