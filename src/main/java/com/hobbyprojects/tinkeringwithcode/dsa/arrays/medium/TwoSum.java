package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    log.info("Enter size of array :- ");
    int size = sc.nextInt();
    log.info("Enter sum of elements :- ");
    int sum = sc.nextInt();
    int[] ar = new int[size];
    for (int i = 0; i < size; i++) {
      log.info("Enter elements in an array :- ");
      ar[i] = sc.nextInt();
    }
    log.info("The array pair using brute force:-");
    displayContent(twoSumUsingBruteForce(ar, sum));
    log.info("The array pair using two pointer:-");
    displayContent(twoSumUsingTwoPointer(ar, sum));
    log.info("The array pair using hashmap:-");
    displayContent(twoSumUsingHashMap(ar, sum));
  }

  public static void displayContent(int[] ar) {
    log.info("[");
    for (int j : ar) {
      log.info(j + ",");
    }
    log.info("]");
  }

  public static int[] twoSumUsingTwoPointer(int[] ar, int target) {
    int i = 0;
    int j = ar.length - 1;
    int[] result = new int[2];

    while (i < j) {
      if (ar[i] + ar[j] > target) {
        j--;
      }
      if (ar[i] + ar[j] < target) {
        i++;
      }
      if (ar[i] + ar[j] == target) {
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
      }
    }
    return result;
  }

  public static int[] twoSumUsingBruteForce(int[] ar, int sum) {
    int[] result = new int[2];
    int k = 0;
    //      Brute Force
    for (int i = 0; i < ar.length; i++) {
      for (int j = i + 1; j < ar.length; j++) {
        if (ar[i] + ar[j] == sum) {
          result[k++] = i + 1;
          result[k] = j + 1;
          return result;
        }
      }
    }
    return result;
  }

  public static int[] twoSumUsingHashMap(int[] ar, int sum) {
    int[] result = new int[2];
    Map<Integer, Integer> elementIndexMap = new HashMap<>();
    for (int i = 0; i < ar.length; i++) {
      int rem = sum - ar[i];
      if (elementIndexMap.containsKey(rem)) {
        result[1] = i + 1;
        result[0] = elementIndexMap.get(ar[i]) + 1;
      }
      elementIndexMap.put(ar[i], i);
    }
    return result;
  }
}
