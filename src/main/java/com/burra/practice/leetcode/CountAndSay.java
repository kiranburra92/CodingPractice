package com.burra.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public String countAndSay(int num) {
        String n = "1 ";
        while(num-->1) {
            System.out.println(n);
            char curr = n.charAt(0);
            int count = 0;
            String result = "";
            for (int i = 0; i < n.length(); i++) {
                if (curr == n.charAt(i)) {
                    count++;
                } else {
                    result = result + count + "" + curr;
                    curr = n.charAt(i);
                    count = 1;
                }
            }
            // In below for loop, previous character is processed in current iteration. That is
            // why a dummy character is added to make sure that loop runs one extra iteration.
            n = result+" ";
        }
        return  n.trim();
    }
}

public class CountAndSay {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String n = line;

            String ret = new Solution().countAndSay(Integer.parseInt(n));

            String out = (ret);

            System.out.print(out);
        }
    }
}
