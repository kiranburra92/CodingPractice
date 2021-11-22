package com.burra.practice.crackingCodingInterview.sortingAndSearching;

// Merge two sorted arrays. Largest array consist addition space to accomidate another array.
public class MergeTwoSortedArrays {

  void merge(int[] A, int[] B, int lastA, int lastB) {
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    int newIndex = indexA + indexB - 1;

    while (newIndex >= 0) {
      if (indexA >= 0 && A[indexA] > B[indexB]) {
        A[newIndex] = A[indexA];
        indexA--;
      } else {
        A[newIndex] = B[indexA];
        indexB--;
      }
      newIndex--;
    }
  }
}
