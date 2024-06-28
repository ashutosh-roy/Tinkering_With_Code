package com.hobbyprojects.tinkeringwithcode.dsa.sorting;

import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        int[] ar = {0, 58, 29, 2, 65, 100};
        mergeSort(ar, 0, ar.length - 1);
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i] + ", ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        // Store the elements from the two subarrays (based in the index given by recursive function) into a temporary array
        while ((left <= mid) && (right <= high)) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // Add remaining elements into left array
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        // Add remaining elements into right array
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // Put all the elements back into the main array !
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}
