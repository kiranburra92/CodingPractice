package com.burra.practice.leetcode;

public class AddBinaryStrings {

  public static String addBinary(String a, String b) {
    String result = "";
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0) {
      int temp = carry;
      temp += (i >= 0) ? a.charAt(i) - '0' : 0;
      temp += (j >= 0) ? b.charAt(j) - '0' : 0;
      carry = temp / 2;
      result = temp % 2 + result;
      i--;
      j--;
    }
    return carry > 0 ? carry + result : result;
  }

  public static void main(String... args) {
    System.out.println(addBinary("11", "1"));
    System.out.println(addBinary("1010", "1011"));
  }
}
