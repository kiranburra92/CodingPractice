package com.burra.practice.leetcode;

public class ToLowerCase {

  public String toLowerCase(String s) {
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      if (ch[i] >= 'A' && ch[i] <= 'Z') {
        ch[i] = (char) ('a' + (ch[i] - 'A'));
      }
    }
    return String.valueOf(ch);
  }
}
