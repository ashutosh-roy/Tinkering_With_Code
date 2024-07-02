package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    public static void main(String[] args) {
        int[] ar = {1, 1, 1, 2, 2};
        int target = 4;
        List<List<Integer>> combinedResult = new ArrayList<>();
        Arrays.sort(ar);
        findCombinations(0, target, ar, combinedResult, new ArrayList<>());
        for (int i = 0; i < combinedResult.size(); i++) {
            for (int j = 0; j < combinedResult.get(i).size(); j++) {
                System.out.print(combinedResult.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static void findCombinations(int index, int target, int[] ar, List<List<Integer>> combinedResult, List<Integer> eachResult) {
        if (target == 0) {
            combinedResult.add(new ArrayList<>(eachResult));
            return;
        }
        for (int i = index; i < ar.length; i++) {
            if (i > index && ar[i] == ar[i - 1]) continue;
            if (ar[i] > target) break;

            eachResult.add(ar[i]);
            findCombinations(i + 1, target - ar[i], ar, combinedResult, eachResult);
            eachResult.remove(eachResult.size() - 1);
        }
    }
}
