package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsetsOfAnInput {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        findAllSubsets(0, nums, new ArrayList<>(), result);
        for(int i =0;i<result.size();i++)
        {
            for(int j =0;j<result.get(0).size();j++)
            {
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void findAllSubsets(int index, int[] nums, List<Integer> eachSubset, List<List<Integer>> result)
    {
        result.add(new ArrayList<>(eachSubset));
        for(int i=index;i<nums.length;i++)
        {
            eachSubset.add(nums[i]);
            findAllSubsets(i+1, nums, eachSubset, result);
            eachSubset.remove(eachSubset.size()-1);
        }
    }
}
