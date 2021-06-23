package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do
 * not share common letters. If no such two words exist, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 * Example 2:
 *
 * Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 * Example 3:
 *
 * Input: words = ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int max = 0;
        Map<Integer, boolean[]> map = new HashMap<>();

        for(int i = 0 ; i<words.length ; i++) {
            boolean[] booleans = new boolean[26];
            for (char c : words[i].toCharArray()) {
                booleans[c-'a'] = true;
            }
            map.put(i, booleans);
        }

        for(int i = 0 ; i < words.length ; i++) {
            boolean[] first = map.get(i);
            for (int j = i+1 ; j < words.length;j++) {
                boolean[] second = map.get(j);
                boolean flag = true;
                for (int k = 0 ; k < 26 ; k++) {
                    if(first[k] == true && second[k] == true) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    max = Math.max(words[i].length()*words[j].length(), max);
                }
            }
        }
        return max;
    }
}
