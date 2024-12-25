package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {
  public static void main(String[] args) {
    List<List<Integer>> combinedResult = new ArrayList<>();
    int[] ar = {2, 3, 6, 7};
    int target = 7;
    combinationSum(0, ar, target, combinedResult, new ArrayList<>());
    System.out.println("Combination Sum One Output :-");
    for (int i = 0; i < combinedResult.size(); i++) {
      for (int j = 0; j < combinedResult.get(i).size(); j++) {
        System.out.print(combinedResult.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  public static void combinationSum(
      int index,
      int[] ar,
      int target,
      List<List<Integer>> combinedResult,
      List<Integer> eachResult) {
    if (index == ar.length) {
      if (target == 0) {
        System.out.println("Each Result after target match = " + eachResult.toString());
        combinedResult.add(new ArrayList<>(eachResult));
      }
      return;
    }
    if (ar[index] <= target) {
      eachResult.add(ar[index]);
      System.out.println("Each Result = " + eachResult);
      System.out.println("Target = " + (target - ar[index]));
      combinationSum(index, ar, target - ar[index], combinedResult, eachResult);
      eachResult.remove(eachResult.size() - 1);
    }
    combinationSum(index + 1, ar, target, combinedResult, eachResult);
  }
}
