package com.burra.practice.crackingCodingInterview.sortingAndSearching;

// Search an element in a rotated sorted array
public class SearchInRotatedArray {

  int binarySearch(int[] a, int left, int right, int x) {
    int mid = (left + right) / 2;
      if (x == a[mid]) {
          return mid;
      }
      if (right < left) {
          return -1;
      }

    if (a[left] < a[mid]) { // left is normally ordered
      if (x >= a[left] && x < a[mid]) { // search left
        return binarySearch(a, left, mid - 1, x);
      } else {
        return binarySearch(a, mid + 1, right, x);
      }
    } else if (a[mid] < a[left]) { // right is normally order
      if (x > a[mid] && x <= a[right]) { // search right
        return binarySearch(a, mid + 1, right, x);
      } else {
        return binarySearch(a, left, mid - 1, x);
      }
    } else if (a[mid] == a[left]) { // left or right half is repeated
      if (a[mid] != a[right]) {
        return binarySearch(a, mid + 1, right, x);
      } else {
        int result = binarySearch(a, left, mid - 1, x);
          if (result == -1) {
              return binarySearch(a, mid + 1, right, x);
          } else {
              return result;
          }
      }
    }
    return -1;
  }
}
