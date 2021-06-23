package com.burra.practice.hackerRank;

public class Flippingbits {
    static long flippingBits(long n) {
        // All ones in 2^32 long i.e., 2**32-1
        long large = 4294967295L;
        return n ^ large;

    }
}
