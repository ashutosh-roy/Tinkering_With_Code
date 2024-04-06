package com.hobbyprojects.tinkeringwithcode.dsa.sorting;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class InsertionSort {

    public static void main(String[] args) {
        int[] ar = {14, 9, 8, 5, 19, 20};
        insertionSort(ar);
    }

    static void insertionSort(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            int j = i;
            /*
             * ar[j] - Element at the right
             * ar[j-1] - Element at the left
             * */
            while (j > 0 && ar[j - 1] > ar[j]) {
                int temp = ar[j - 1];
                ar[j - 1] = ar[j];
                ar[j] = temp;
                j--;
            }
        }
        log.info("Output of insertion sort :- ");
        Arrays.stream(ar).forEach(System.out::println);
    }
}