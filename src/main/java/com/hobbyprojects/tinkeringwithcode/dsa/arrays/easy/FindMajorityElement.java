package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElement {
  public static void main(String[] args) {
    int[] nums = new int[] {3, 3, 1, 1, 1, 1, 2};
    System.out.println("Majority Element using hashmap :- " + findMajorityElement(nums));
    nums = new int[] {3, 2, 3};
    System.out.println(
        "Majority Element using Moore's algo :- " + findMajorityElementOptimised(nums));
  }

  private static int findMajorityElementOptimised(int[] nums) {
    int count = 0, element = nums[0];
    for (int i : nums) {
      count = (i == element) ? count + 1 : count - 1;
      // [3,2,3]
      if (count == 0) {
        element = i;
        count = 1;
      }
    }
    return element;
  }

  private static int findMajorityElement(int[] nums) {
    int max = Integer.MIN_VALUE, maxKey = 0;
    Map<Integer, Integer> numFreqMap = new HashMap<>();
    for (int i : nums) {
      if (!numFreqMap.containsKey(i)) {
        numFreqMap.put(i, 1);
      } else {
        numFreqMap.put(i, numFreqMap.get(i) + 1);
      }
    }
    for (Map.Entry<Integer, Integer> eachNum : numFreqMap.entrySet()) {
      if (max < eachNum.getValue()) {
        max = eachNum.getValue();
        maxKey = eachNum.getKey();
      }
    }
    return maxKey;
  }
}
