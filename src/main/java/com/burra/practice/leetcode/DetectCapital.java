package com.burra.practice.leetcode;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA". All letters in this word are not capitals, like "leetcode". Only
 * the first letter in this word is capital, like "Google". Otherwise, we define that this word doesn't use capitals in
 * a right way.
 */
public class DetectCapital {

  public boolean detectCapitalUse(String word) {
    int n = word.length();
    if (n == 1) {
      return true;
    }

    // case 1: All capital
    if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
      for (int i = 2; i < n; i++) {
        if (Character.isLowerCase(word.charAt(i))) {
          return false;
        }
      }
      // case 2 and case 3
    } else {
      for (int i = 1; i < n; i++) {
        if (Character.isUpperCase(word.charAt(i))) {
          return false;
        }
      }
    }

    // if pass one of the cases
    return true;
  }
}
