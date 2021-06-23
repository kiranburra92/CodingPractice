package com.burra.practice.crackingCodingInterview.sortingAndSearching;

import java.util.Arrays;

// Given an array of integers, sort the array into an alternating sequence of peaks and valleys
public class PeaksAndValleys {
    void sortValleyPeaks(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            int temp = array[i - 1];
            array[i - 1] = array[i];
            array[i] = temp;
        }
    }
}
