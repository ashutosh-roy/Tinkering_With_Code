package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] ar = new int[]{12, 12, 5, 4, 3, 2};
        log.info("Array without duplicates :- ");
        removeDuplicates(ar);
    }

    //  Using HashSet but the problem here is that the order is not guranteed
    static int[] removeDuplicates(int[] ar) {
        HashSet<Integer> distinctElements = new HashSet<>();
        for (int i : ar) {
            distinctElements.add(i);
        }
        int k = 0;
        int[] arr = new int[distinctElements.size()];
        for (int element : distinctElements) {
            arr[k++] = element;
        }
        Arrays.stream(arr).forEach(element -> log.info("%s".formatted(element)));
        return arr;
    }


}
