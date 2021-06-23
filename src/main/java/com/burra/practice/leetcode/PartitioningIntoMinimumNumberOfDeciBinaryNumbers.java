package com.burra.practice.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 *
 * Given a string n that represents a positive decimal integer, return the minimum number of positive
 * deci-binary numbers needed so that they sum up to n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 *
 * Example 2:
 *
 * Input: n = "82734"
 * Output: 8
 *
 * Example 3:
 *
 * Input: n = "27346209830709182346"
 * Output: 9
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    // The idea to do this is to first observe carefully that we need to calculate minimum number of possible
    // psuedo binary numbers. To do this we find a new number m such that if for a place in given number n,
    // the digit is non-zero then the digit in that place in m is 1 otherwise zero. For example, if n = 5102,
    // then m will be 1101. Then we will print this number m and subtract m from n. We will keep repeating
    // these steps until n is greater than zero.
    public int minPartitions(String x) {
        int n = Integer.parseInt(x);
        List<Integer> results = new ArrayList<>();
        while (n != 0)
        {
            // calculate m (A number that has same
            // number of digits as n, but has 1 in
            // place of non-zero digits 0 in place
            // of 0 digits)
            int temp = n, m = 0, p = 1;
            while(temp != 0)
            {
                int rem = temp % 10;
                temp = temp / 10;

                if (rem != 0)
                    m += p;

                p *= 10;
            }

            results.add(m);

            // subtract m from n
            n = n - m;
        }
        return results.size();
    }

    // correct solution but No explantion
    public int minPartitions2(String n) {
        int max = 1;
        for(char c : n.toCharArray()) {
            max = Math.max(max, c-'0');
        }
        return max;
    }
}
