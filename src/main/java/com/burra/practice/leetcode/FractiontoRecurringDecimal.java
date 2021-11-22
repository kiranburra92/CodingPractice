package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {

  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    if (denominator == 0) {
      return "";
    }
    String result = "";
    if ((numerator < 0) ^ (denominator < 0)) {
      result += '-';
    }
    long num = numerator;
    num = Math.abs(num);
    long den = denominator;
    den = Math.abs(den);
    result += String.valueOf(num / den);
    long rem = (num % den) * 10;
    if (rem == 0) {
      return result;
    }
    Map<Long, Integer> map = new HashMap<>();
    result += ".";
    while (rem != 0) {
      if (map.containsKey(rem)) {
        String part1 = result.substring(0, map.get(rem));
        String part2 = result.substring(map.get(rem), result.length());
        return part1 + "(" + part2 + ")";
      }
      map.put(rem, result.length());
      result += String.valueOf(rem / den);
      rem = (rem % den) * 10;
    }

    return result;
  }
}
