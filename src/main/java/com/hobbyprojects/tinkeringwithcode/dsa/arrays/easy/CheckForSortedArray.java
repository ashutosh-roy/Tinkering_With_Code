package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CheckForSortedArray {

    public static void main(String[] args) {
        int[] ar = new int[]{12, 4, 20, 9};
        log.info("For array :-");
        Arrays.stream(ar).forEach(System.out::println);
        if (checkIfArrayIsSorted(ar)) {
            log.info("Array is sorted");
        } else {
            log.info("Array is not sorted");
        }

        ar = new int[]{12, 4, 3, 2};
        log.info("For array :-");
        Arrays.stream(ar).forEach(System.out::println);
        if (checkIfArrayIsSorted(ar)) {
            log.info("Array is sorted");
        } else {
            log.info("Array is not sorted");
        }

        ar = new int[]{1, 4, 5, 7};
        log.info("For array :-");
        Arrays.stream(ar).forEach(System.out::println);
        if (checkIfArrayIsSorted(ar)) {
            log.info("Array is sorted");
        } else {
            log.info("Array is not sorted");
        }
    }

    private static Boolean checkIfArrayIsSorted(int[] ar) {
        int max = Integer.MIN_VALUE;
        int indexForMax = 0;
        for (int i = 0; i < ar.length; i++) {
            if (max < ar[i]) {
                max = ar[i];
                indexForMax = i;
            }
        }
        return indexForMax == 0 || indexForMax == ar.length - 1;
    }

}