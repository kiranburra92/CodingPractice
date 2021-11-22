package com.burra.practice.crackingCodingInterview.recursionAndDP;

// In a sorted array, find the index of the array whose value is the index i.e, A[i] = i
public class MagicIndex {

  // If all the array elements are distinct
  int magic(int[] A, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (A[mid] == mid) {
      return mid;
    } else if (A[mid] < mid) {
      return magic(A, mid + 1, end);
    }
    return magic(A, start, mid - 1);
  }

  // If array has repeated number but
  int magicRepeated(int[] A, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (A[mid] == mid) {
      return mid;
    }

    int leftIndex = Math.min(A[mid], mid - 1);
    int left = magicRepeated(A, start, leftIndex);
    if (left > -1) {
      return left;
    }

    int rightIndex = Math.max(A[mid], mid + 1);
    int right = magicRepeated(A, rightIndex, end);
    return right;
  }
}
