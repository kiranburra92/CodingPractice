package com.burra.practice.leetcode;

import java.util.Arrays;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first
 * half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 * Example 3:
 *
 * Input: s = "MerryChristmas"
 * Output: false
 * Example 4:
 *
 * Input: s = "AbCdEfGh"
 * Output: true
 */
public class DetermineifStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        boolean result = false;
        int first = 0;
        int second = 0;
        for(char c : s.substring(0, s.length()/2).toCharArray()) {
            if (checkIsVowel(c)) {
                first++;
            }
        }
        for(char c : s.substring(s.length()/2).toCharArray()) {
            if (checkIsVowel(c)) {
                second++;
            }
        }
        return first == second ? true : false;
    }

    public boolean checkIsVowel(char c){
        char[] ch = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char v : ch){
            if(c == v)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineifStringHalvesAreAlike().halvesAreAlike("textbook"));
    }
}
