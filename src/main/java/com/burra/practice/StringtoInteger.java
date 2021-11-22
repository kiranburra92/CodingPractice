package com.burra.practice;

public class StringtoInteger {

  public static void rejectIfNull(String s) {
    System.out.println(s.trim());
  }

  /**
   * Converts string to integer eg:  "56732"         --> 56732 "    444    "   --> 444 "432 qwerty"    --> 432 "qwerty
   * 432"    --> 0 "-433"          --> -433 "+433"          --> 433 "-+433","+-433" --> 433 "98765432109"   -->
   * Integer.MAX_VALUE "-98765432109"  --> Integer.MIN_VALUE
   */
  public static int atoi(String str) {
    double num = 0;
    str = str.trim();
    if (str == null || str.length() == 0) {
      return 0;
    }

    int i = 0;
    int bit = 1;
    if (str.charAt(0) == '-' && str.length() > 1) {
      bit = -1;
      i++;
    }
    if (str.charAt(0) == '+' && i == 0) {
      i++;
    }
    for (; i < str.length(); i++) {
      if (str.charAt(i) < '0' || str.charAt(i) > '9') {
        break;
      }
      num = num * 10 + (int) (str.charAt(i) - '0');
    }
    num = num * bit;
    if (num > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (num < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) num;
  }

  public static void main(String args[]) {

    rejectIfNull(null);

    System.out.println(atoi("56732"));
    System.out.println(atoi("   555    "));
    System.out.println(atoi("432 qwerty"));
    System.out.println(atoi("qwerty 432"));
    System.out.println(atoi("-433"));
    System.out.println(atoi("+433"));
    System.out.println(atoi("-+433"));
    System.out.println(atoi("+-433"));
    System.out.println(atoi("987654321789"));
    System.out.println(atoi("-987654321987"));

  }
}
