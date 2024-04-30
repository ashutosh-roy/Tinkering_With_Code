package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class RotateArrayToRight {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Scanner sc = new Scanner(System.in);
        log.info("How many right shifts to perform?");
        int k = sc.nextInt();

//      Approach 1
        int[] result = rotate(nums, k);
        log.info("Approach 1 : Final Output After Array Rotation");
        Arrays.stream(result).forEach(System.out::println);

//      Approach 2 : recursively use approach 1 : O(size of array * k)
        result = shiftElementsToRightPartRecursively(nums, k);
        log.info("Approach 2 : Final Output After Array Rotation");
        Arrays.stream(result).forEach(System.out::println);

//TODO  Approach 3 : use hashmap
//        shiftElementsToRightUsingMap();

    }


    /**
     * Brute Force
     */
    public static int[] shiftElementsToRightPartRecursively(int[] nums, int k) {
        int size = nums.length;
        int[] result = new int[size];
        result[0] = nums[size - 1];
        System.arraycopy(nums, 0, result, 1, size - 1);
//        base condition
        if (k == 0) {
            return nums;
        }
        return shiftElementsToRightPartRecursively(result, --k);
    }

    public static int[] shiftElementsToRight(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        result[0] = nums[size - 1];
        System.arraycopy(nums, 0, result, 1, size - 1);
        return result;
    }

    public static int[] rotate(int[] nums, int k) {
        int j = 0;
        while (j < k) {
            nums = shiftElementsToRight(nums);
            j++;
        }
        return nums;
    }

    /**
     * Optimised
     */
//    int[] shiftElementsToRightUsingMap(int[] nums) {
//
//    }
}
