package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class Sort0s1s2s {
  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 2, 2};
    sortColors(nums);
    System.out.println("Sorted Array by hashmap method:- ");
    for (int j : nums) {
      System.out.println(j);
    }
    nums = new int[] {2, 1, 0, 1, 0, 2, 2};
    sortColorsOptimised(nums);
    System.out.println("Sorted Array using optimised method:- ");
    for (int j : nums) {
      System.out.println(j);
    }
  }

  public static void sortColors(int[] nums) {
    Map<Integer, Integer> elementCountMap = new HashMap<>();
    for (int num : nums) {
      if (elementCountMap.containsKey(num)) {
        elementCountMap.put(num, elementCountMap.get(num) + 1);
      } else {
        elementCountMap.put(num, 1);
      }
    }
    int i = 0;
    for (Map.Entry<Integer, Integer> eachEntry : elementCountMap.entrySet()) {
      System.out.println("Key = " + eachEntry.getKey() + "Value = " + eachEntry.getValue());
      int value = eachEntry.getValue() + i;
      while (i < value) {
        nums[i] = eachEntry.getKey();
        i++;
      }
    }
  }

  public static void sortColorsOptimised(int[] nums) {
    int low = 0, high = nums.length - 1, mid = 0;
    while (mid <= high) {
      if (nums[mid] == 0) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;

        low++;
        mid++;
      } else if (nums[mid] == 1) {
        mid++;
      } else {
        int temp = nums[mid];
        nums[mid] = nums[high];
        nums[high] = temp;

        high--;
      }
    }
  }
}
