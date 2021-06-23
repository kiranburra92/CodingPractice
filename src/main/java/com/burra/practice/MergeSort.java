package com.burra.practice;

public class MergeSort {
    void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - low;

        int[] l1 = new int[n1];
        int[] l2 = new int[n2];

        int i, j;
        for (i = 0; i < n1; i++) {
            l1[i] = array[low + i];
        }

        for (i = 0; i < n2; i++) {
            l2[i] = array[mid + 1 + i];
        }

        i = 0;
        j = 0;
        while (n1 > i && n2 > j) {
            if(l1[i] <= l2[j]) {
               array[low] = l1[i];
               i++;
            }
            else {
                array[low] = l2[j];
                j++;
            }
            low++;
        }

        while (i < n1) {
            array[low] = l1[i];
            i++;
            low++;
        }
        while (j < n2) {
            array[low] = l2[j];
            j++;
            low++;
        }

    }

    void mergeSort(int[] array, int low, int high) {
        if (low > high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length);

    }
}
