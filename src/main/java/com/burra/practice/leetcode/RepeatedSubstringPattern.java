package com.burra.practice.leetcode;

/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: Truea
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

/**
 * Solution
 *
 * Solution 1: input string S + S，means S is repeated
 *
 * explanation: If the string S has repeated block, it could be described in terms of pattern.
 * S = SpSp(For example,Shas two repeatable block at most)
 * If we repeat the string, thenSS=SpSpSpSp.
 * Destroying first and the last pattern by removing each character, we generate a newS2=SxSpSpSy.
 * If the string has repeatable pattern inside,S2should have validSin its string.
 *
 * Consider a stringS="helloworld". Now, given another stringT="lloworldhe",
 * can we figure out ifTis a rotated version ofS? Yes, we can! We check ifSis a substring ofT+T
 *
 * Solution 2: The length of the repeating substring must be a divisor of the length of the input string
 *
 * Search for all possible divisor ofstr.length, starting forlength/2
 * Ifiis a divisor oflength, repeat the substring from0toi,the number of timesiis contained ins.length
 * If the repeated substring is equals to the inputstrreturntrue
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i = l/2; i>=1; i--) {
            if(l%i == 0){
                int m = l/i;
                String subStr = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<m ; j++) {
                    sb.append(subStr);
                }
                if(sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
