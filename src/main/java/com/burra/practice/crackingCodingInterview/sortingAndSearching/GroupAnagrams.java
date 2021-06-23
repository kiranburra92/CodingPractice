package com.burra.practice.crackingCodingInterview.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Write method to sort an array of strings so that all anagrams are next to each other
public class GroupAnagrams {
    void sort(String[] array) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : array) {
            String key = sortChars(s);
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(s);
        }
        int i = 0;
        for (String k : map.keySet()) {
            List<String> v = map.get(k);
            for (String s : v) {
                array[i++] = s;
            }
        }
    }

    private String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // Alternativly use custome compartor to sort the array which takes O(nlog(n)) times

    void sort1(String[] array) {
        Arrays.sort(array, new Comparator<String>() {
            private String sortChars(String s) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                return new String(c);
            }

            @Override
            public int compare(String o1, String o2) {
                return sortChars(o1).compareTo(sortChars(o2));
            }
        });
    }
}
