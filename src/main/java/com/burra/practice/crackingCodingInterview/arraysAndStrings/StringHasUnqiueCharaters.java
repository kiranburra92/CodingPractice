package com.burra.practice.crackingCodingInterview.arraysAndStrings;

public class StringHasUnqiueCharaters {

  public static boolean isStringUnique(String s) {
    // all ascii characters
    boolean[] flag = new boolean[128];
    for (char c : s.toCharArray()) {
      if (flag[c] == true) {
        return false;
      }
      flag[c] = true;
    }
    return true;
  }

  // if string has characters between a - z, we can use bitwise operator
  public static boolean isStringUnique1(String s) {
    int checker = 0;
    for (char c : s.toCharArray()) {
      int val = c - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker = checker | (1 << val);
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isStringUnique("1bfdh"));
    System.out.println(isStringUnique("derd"));
    System.out.println(isStringUnique1("1bfdh"));
    System.out.println(isStringUnique1("derd"));
  }
}
