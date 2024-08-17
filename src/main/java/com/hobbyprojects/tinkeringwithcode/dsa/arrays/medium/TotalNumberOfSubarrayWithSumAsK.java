package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class TotalNumberOfSubarrayWithSumAsK {
    public static void main(String[] args) {
        int k = 10;
        int[] num = new int[]{2, 3, 5, 9, 1};
        System.out.printf("Max Subarray Length = %s%n", totalNumberOfSubarraysWithSumAsK(num, k));
    }

    private static int totalNumberOfSubarraysWithSumAsK(int[] num, int k) {
        int maxCount = 0, sum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            if (prefixSumMap.containsKey(sum - k)) {
                maxCount += prefixSumMap.get(sum - k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }
        return maxCount;
    }

}
