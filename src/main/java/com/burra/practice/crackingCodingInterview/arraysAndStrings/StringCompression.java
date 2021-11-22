package com.burra.practice.crackingCodingInterview.arraysAndStrings;

// compress string and if result length is greater than original string return original string
public class StringCompression {

  public static String compress(String s) {
    StringBuilder sb = new StringBuilder();
    int n = s.length();
    int count = 1;
    int i = 1;
    for (; i < n; i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        count++;
      } else {
        sb.append(s.charAt(i - 1)).append(count);
        count = 1;
      }
    }
    sb.append(s.charAt(i - 1)).append(count);
    return sb.length() > s.length() ? s : sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(compress("aaaabbbcccccd"));
    System.out.println(compress("aaaabbbccccc"));
    System.out.println(compress("abcd"));
  }
}
