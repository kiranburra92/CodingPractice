package com.burra.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a
 * result, and there will not be any division by zero operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"] Output: 9 Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"] Output: 6 Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] Output: 22 Explanation: ((10 * (6 / ((9 +
 * 3) * -11))) + 17) + 5 = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 = (0
 * + 17) + 5 = 17 + 5 = 22
 */
public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    Stack<Integer> stack = new Stack<>();
    for (String s : tokens) {
      if (set.contains(s)) {
        int a = stack.pop();
        int b = stack.pop();
        if ("+".equals(s)) {
          stack.push(b + a);
        } else if ("-".equals(s)) {
          stack.push(b - a);
        } else if ("*".equals(s)) {
          stack.push(b * a);
        } else {
          stack.push(b / a);
        }
      } else {
        stack.push(Integer.parseInt(s));
      }
    }
    return stack.pop();
  }
}
