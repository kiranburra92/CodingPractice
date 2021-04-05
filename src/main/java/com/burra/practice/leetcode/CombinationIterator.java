package com.burra.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an Iterator class, which has: <br>
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number
 * combinationLength as arguments.<br>
 * A function next() that returns the next combination of length combinationLength in lexicographical order.<br>
 * A function hasNext() that returns True if and only if there exists a next combination. <br>
 *
 * Example: <br>
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator. <br>
 *
 * iterator.next(); // returns "ab" <br>
 * iterator.hasNext(); // returns true <br>
 * iterator.next(); // returns "ac" <br>
 * iterator.hasNext(); // returns true <br>
 * iterator.next(); // returns "bc" <br>
 * iterator.hasNext(); // returns false <br>
 */
public class CombinationIterator {
    Queue<String> q = new LinkedList<>();
    StringBuilder sb;
    CombinationIterator(String characters, int length) {
        sb = new StringBuilder();
        findAll(characters, 0, length);
    }

    void findAll(String character, int index, int len) {
        if(len ==0){
            q.add(sb.toString());
            return;
        }
        for(int i = index; i<character.length(); i++){
            sb.append(character.charAt(i));
            findAll(character, i+1, len-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    String next() {
        if(hasNext()){
            return q.poll();
        }
        return "";
    }

    boolean hasNext() {
        return !q.isEmpty();
    }

    public static void main(String...args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        System.out.println(iterator.next()); // returns "ab"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "ac"
        System.out.println(iterator.hasNext()); // returns true
        System.out.println(iterator.next()); // returns "bc"
        System.out.println(iterator.hasNext()); // returns false
    }
}
