package com.hobbyprojects.tinkeringwithcode.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ar = {9, 14, 8, 6, 5, 4};
        bubbleSort(ar);
    }

    static void bubbleSort(int[] ar) {
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j + 1];
                    ar[j + 1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        Arrays.stream(ar).forEach(System.out::println);
    }
}