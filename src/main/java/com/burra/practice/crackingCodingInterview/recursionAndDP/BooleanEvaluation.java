package com.burra.practice.crackingCodingInterview.recursionAndDP;

import java.util.Map;

// Given a boolean expression consisting of 0s and 1s, with expected result. Find number of ways the expression can
// be evaluated to get the result. If not return -1;
public class BooleanEvaluation {

  public int countEval(String str, boolean result, Map<String, Integer> memo) {
    if (str.length() == 0) {
      return 0;
    }
    if (str.length() == 1) {
      return StringToBool(str) == result ? 1 : 0;
    }
    if (memo.containsKey(result + str)) {
      return memo.get(result + str);
    }

    int ways = 0;
    for (int i = 1; i < str.length(); i += 2) {
      char c = str.charAt(i);
      String left = str.substring(0, i);
      String right = str.substring(i + 1);
      int leftTrue = countEval(left, true, memo);
      int leftFalse = countEval(left, false, memo);
      int rightTrue = countEval(right, true, memo);
      int rightFalse = countEval(right, false, memo);
      int total = (leftFalse + leftTrue) * (rightFalse + rightTrue);
      int totalTrue = 0;
      if (c == '^') {
        totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
      } else if (c == '&') {
        totalTrue = leftTrue * rightTrue;
      } else if (c == '|') {
        totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
      }
      int subways = result ? totalTrue : total - totalTrue;
      ways += subways;
    }
    memo.put(result + str, ways);
    return ways;
  }

  private boolean StringToBool(String str) {
    return str.equals("1") ? true : false;
  }
}
