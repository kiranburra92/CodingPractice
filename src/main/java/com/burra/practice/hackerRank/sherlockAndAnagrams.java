package com.burra.practice.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sample Input 0
 *
 * 2
 * abba
 * abcd
 *
 * Sample Output 0
 *
 * 4
 * 0
 */
public class sherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int total = 0;
//        Map<String, Integer> mp = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                char[] ch = s.substring(i, j).toCharArray();
//                Arrays.sort(ch);
//                String temp = new String(ch);
//                mp.put(temp, mp.getOrDefault(temp, -1)+1);
//            }
//        }
//        for(int i : mp.values())
//            total += i;
        return total;
    }

    public static void main(String[] args) {
        sherlockAndAnagrams("abba");
    }
}
