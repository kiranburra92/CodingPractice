package com.burra.practice.leetcode;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int total = 0;
        for(char c : s.toCharArray()){
            total = total * 26 + c - 'A' + 1;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        // AA = 26 * 1 + 1
        // AAA = 26 * 2 + 26 * 1 + 1
        // AB = 26 * 1 + 2
    }
}
