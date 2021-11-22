package com.burra.practice.crackingCodingInterview.sortingAndSearching;

// Search in a array like data structure, which has no size method, but has getElementAt(i) in O(1) time. if i is
// beyond the bounds, it return -1
public class SortedSearchNoSize {

  int search(Listy list, int value) {
    int index = 1;

    // exponential search
    while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
      index *= 2;
    }
    return binarySearch(list, index / 2, index, value);
  }

  private int binarySearch(Listy list, int low, int high, int value) {
    int mid;
    while (low < high) {
      mid = (low + high) / 2;
      int middle = list.elementAt(mid);
      if (middle == -1 || middle > value) {
        high = mid - 1;
      } else if (middle < value) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public class Listy {

    public int data;

    public Listy() {
      data = 0;
    }

    public int elementAt(int i) {
      return i;
    }
  }
}
