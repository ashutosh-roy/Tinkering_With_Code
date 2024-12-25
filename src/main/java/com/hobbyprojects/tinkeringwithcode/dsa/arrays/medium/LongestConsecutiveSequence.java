package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import java.util.Arrays;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int[] ar = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println("Longest Consecutive Sequence :- " + longestConsecutive(ar));
  }

  public static int longestConsecutive(int[] ar) {
    int j, k = 0, maxLen = Integer.MIN_VALUE;
    Arrays.sort(ar);
    if (ar.length == 0) {
      return 0;
    }
    for (j = 0; j < (ar.length - 1); j++) {
      if ((ar[j] == ar[j + 1] - 1)) {
        k++;
      } else if (ar[j] == ar[j + 1]) {
        // DO nothing
      } else {
        maxLen = Math.max(maxLen, k + 1);
        k = 0;
      }
    }
    maxLen = Math.max(maxLen, k + 1);
    return maxLen;
  }
}
