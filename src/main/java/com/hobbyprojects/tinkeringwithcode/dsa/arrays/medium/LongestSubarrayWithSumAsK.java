package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class LongestSubarrayWithSumAsK {

    public static void main(String[] args) {
        int k = 6;
        int[] num = new int[]{3, 2, 3};
        log.info("Max Subarray Length = %s".formatted(subarraySumUsingHashing(num, k)));
        log.info("Max Subarray with Two Pointers Length = %s".formatted(subarraySumUsingTwoPointers(num, k)));
    }

    public static int subarraySumUsingTwoPointers(int[] nums, int k) {
        int start = 0, end = 0;
        // Since the end starts with '1'
        int sum = nums[0], maxLen = 0, n = nums.length;
        while (end < n) {
            // increase values from the start if sum > k
            while (start <= end && sum > k) {
                sum -= nums[start];
                start++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }

            end++;
            if (end < n) sum += nums[end];
        }

        return maxLen;
    }

    public static int subarraySumUsingHashing(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            //  Calculate prefixSum
            sum += nums[i];
            //  Compare and check value of sum and 'k'
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
                dryRun("sum == k", preSumMap, maxLen, sum);
            }
            int rem = sum - k;
            //  Compare and check value of sum and 'k'
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
                dryRun("Contains Remainder", preSumMap, maxLen, sum);
            }
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
                dryRun("", preSumMap, maxLen, sum);
            }
        }
        return maxLen;
    }

    static void dryRun(String message, Map<Integer, Integer> prefixSum, int ans, int sum) {
        log.info("For %s, ".formatted(message));
        prefixSum.forEach((key, value) ->
                log.info("key = %s and value = %s".formatted(key, value)));
        log.info("Max Length = %s".formatted(ans));
        log.info("Sum = %s".formatted(sum));
    }
}
