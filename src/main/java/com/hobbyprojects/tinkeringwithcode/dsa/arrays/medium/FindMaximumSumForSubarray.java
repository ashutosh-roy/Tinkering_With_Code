package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

public class FindMaximumSumForSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray with:-" + findMaximumSumForSubarray(nums));
        System.out.println("Maximum Subarray optimised :-" + findMaximumSumForSubarrayOptimised(nums));
        System.out.println("Display the maximum subarray Part 1:- ");
        displayMaximumSubarrayWithSumK(nums);
        nums = new int[]{-4, -2, -3, 0, 5, 6, 10};
        System.out.println("Display the maximum subarray Part 2:- ");
        displayMaximumSubarrayWithSumK(nums);
    }

    private static int findMaximumSumForSubarrayOptimised(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    private static int findMaximumSumForSubarray(int[] nums) {
        int i, j, n = nums.length, maxSum = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            int sum = 0;
            for (j = i; j < n; j++) {
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    private static void displayMaximumSubarrayWithSumK(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                start = i;
                sum = 0;
            }
            if (max < sum) {
                max = sum;
                end = i;
            }
        }
        for (int i = start + 1; i <= end; i++) {
            System.out.println(nums[i] + ", ");
        }
    }
}
