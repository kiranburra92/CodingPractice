package com.burra.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters
 * only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word. For example, the word 'apple'
 * becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
 * "ma". For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1. For example, the
 * first word gets "a" added to the end, the second word gets "aa" added to the end and so on. Return the final sentence
 * representing the conversion from S to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "I speak Goat Latin" Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 */
public class GoatLatin {

  public String toGoatLatin(String S) {
    List<StringBuilder> list = new ArrayList<>();
    String[] words = S.split(" ");
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    String a = "";
    StringBuilder sb;
    for (String w : words) {
      sb = new StringBuilder();
      a = a + 'a';
      if (vowels.contains(w.charAt(0))) {
        sb.append(w).append("ma").append(a);
      } else {
        sb.append(w.substring(1)).append(w.charAt(0)).append("ma").append(a);
      }
      list.add(sb);
    }
    return list.stream().map(StringBuilder::toString).collect(Collectors.joining(" "));
  }
}
