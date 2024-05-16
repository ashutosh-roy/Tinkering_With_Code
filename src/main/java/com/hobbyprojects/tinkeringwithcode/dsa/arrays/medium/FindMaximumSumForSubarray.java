package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

public class FindMaximumSumForSubarray {
    public static void main(String[] args) {
        int[]  nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray with:-" +findMaximumSubarrayWithSumK(nums));
        System.out.println("Display the maximum subarray :- ");
        displayMaximumSubarrayWithSumK(nums);
    }

    private static int findMaximumSubarrayWithSumK(int[] nums) {
        int i, j, n = nums.length, maxSum = Integer.MIN_VALUE;
        for(i=0;i<n;i++)
        {
            int sum = 0;
            for(j=i;j<n;j++)
            {
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    private static void displayMaximumSubarrayWithSumK(int[] nums) {
        int i, j, n = nums.length, maxSum = Integer.MIN_VALUE;
        for(i=0;i<n;i++)
        {
            int sum = 0;
            for(j=i;j<n;j++)
            {
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
    }
}
