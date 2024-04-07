package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondLargestAndSmallestElementInAnArray {

    public static void main(String[] args) {
        int[] ar = {12, 35, 1, 10, 34, 1};
        log.info("Second Largest Element in an array :- %s".formatted(findSecondLargestElement(ar)));
        log.info("Second Smallest Element in an array :- %s".formatted(findSecondSmallestElement(ar)));
    }

    public static int findSecondLargestElement(int[] ar) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i : ar) {
            if (max < i) {
                secondMax = max; // To store the previous value of MAX
                max = i;
            }
            if (secondMax < i && max != i) { // Need to skip the MAXIMUM element while checking for 2nd MAX element
                secondMax = i;
            }
        }
        return secondMax;
    }

    public static int findSecondSmallestElement(int[] ar) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i : ar) {
            if (min > i) {
                secondMin = min;
                min = i;
            }
            if (secondMin > i && min != i) {
                secondMin = i;
            }
        }
        return secondMin;
    }
}