package com.burra.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SevenSegmentDisplayToNumber {
    public static void main(String[] args) {
        String example= " _     _  _     _  _  _  _  _ \n" +
                        "| |  | _| _||_||_ |_   ||_||_| \n" +
                        "|_|  ||_  _|  | _||_|  ||_| _|";
        System.out.println(get7segment(example));
    }

    private static String get7segment(String ascii) {
        StringBuilder result = new StringBuilder();

        String[] lines = ascii.split("\n");
        String[] line1;
        String[] line2;
        String[] line3;

        for (int j = 0; j < lines.length - 2; j += 4) {
            line1 = lines[j].split("");
            line2 = lines[j + 1].split("");
            line3 = lines[j + 2].split("");

            StringBuilder pow = new StringBuilder();
            int mod = 3;

            for (int i = 0; i < line1.length; i++) {
                if (i % mod == 0) {
                    String strAs = digitToString(pow.toString());
                    result.append(strAs);
                    pow = new StringBuilder();
                }

                if (line1[i].equals("_") && i % mod == 1)
                    pow.append("0");

                if (line2[i].equals("|") && i % mod == 0)// left
                    pow.append("5");
                if (line2[i].equals("|") && i % mod == 2)// right
                    pow.append("1");
                if (line2[i].equals("_") && i % mod == 1)// bottom
                    pow.append("6");

                if (line3[i].equals("|") && i % mod == 0)// left
                    pow.append("4");
                if (line3[i].equals("|") && i % mod == 2)// right
                    pow.append("2");
                if (line3[i].equals("_") && i % mod == 1)// bottom
                    pow.append("3");

                if (line1.length - 1 == i) {
                    String strAs = digitToString(pow.toString());
                    result.append(strAs);
                    pow = new StringBuilder();
                }
            }


            result.append("\n");
        }
        return result.toString();
    }

    /*
     * Converting single ascii digit to regular digit
     */
    private static String digitToString(String asciiDigit) {
        if (asciiDigit == null || asciiDigit.equals(""))
            return "";
        int pow = 0;
        for (int i = 0; i < asciiDigit.length(); i++)
            pow += Math.pow(2, Character.getNumericValue(asciiDigit.charAt(i)));

        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
            {
                put(63, 0);
                put(6, 1);
                put(91, 2);
                put(79, 3);
                put(102, 4);
                put(109, 5);
                put(125, 6);
                put(7, 7);
                put(127, 8);
                put(111, 9);
            }
        };
        return map.containsKey(pow) ? Integer.toString(map.get(pow)) : "?";
    }
}
