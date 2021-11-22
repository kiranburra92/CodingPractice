package com.burra.practice.leetcode;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace
 * character. Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Example 1: Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become "ac".
 */
public class BackspaceStringCompare {

  public static void main(String args[]) {
    BackspaceStringCompare bsc = new BackspaceStringCompare();
    System.out.println(bsc.backspaceCompare("xywrrmp", "xywrrmu#p"));
  }

  public boolean backspaceCompare(String S, String T) {
    StringBuilder sb = new StringBuilder("");
    StringBuilder tb = new StringBuilder("");
    for (char c : S.toCharArray()) {
      if (c == '#') {
        if (sb.length() > 0) {
          sb.deleteCharAt(sb.length() - 1);
        }
      } else {
        sb.append(c);
      }
    }
    for (char c : T.toCharArray()) {
      if (c == '#') {
        if (tb.length() > 0) {
          tb.deleteCharAt(tb.length() - 1);
        }
      } else {
        tb.append(c);
      }
    }
    return sb.toString().equals(tb.toString());
  }
}
