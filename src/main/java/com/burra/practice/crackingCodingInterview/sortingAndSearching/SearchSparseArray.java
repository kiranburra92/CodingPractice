package com.burra.practice.crackingCodingInterview.sortingAndSearching;

// Given an array of string in a sorted order with empty strings at some of the indexes, search an element
public class SearchSparseArray {
    public int search(String[] array, String s, int first, int last) {
        if (first > last) return -1;
        int mid = (first + last) / 2;
        if (array[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (right > last && left < first) return -1;
                else if (left >= first && !array[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= last && !array[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }
        int i = array[mid].compareTo(s);
        if (i == 0) {
            return mid;
        } else if (i < 0) {
            return search(array, s, mid + 1, last);
        }
        return search(array, s, first, mid - 1);
    }
}
