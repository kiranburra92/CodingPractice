package com.burra.practice.crackingCodingInterview.arraysAndStrings;

// Check if a string is permutation of palindrome
public class PalindromePermutation {
    public static boolean isPalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean isOdd = false;
        for (int i : count) {
            if((i % 2 != 0)) {
                if(!isOdd) {
                    isOdd = true;
                }
                else
                    return false;
            }
        }
        return true;
    }

}
