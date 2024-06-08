package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

/**
 * <h3>Time Complexity :</h3> O(n) + O(n/2) <br><br>
 * <h3>Space Complexity :</h3> O(n/2) + O(n/2) -> O(n)
 */
public class RearrangeElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, i, j = 0, k = 0, temp;
        int[] positives = new int[nums.length];
        int[] negatives = new int[nums.length];
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                positives[j++] = nums[i];
            } else {
                negatives[k++] = nums[i];
            }
        }
        for (i = 0; i < n / 2; i++) {
            nums[2 * i] = positives[i];
            nums[(2 * i) + 1] = negatives[i];
        }
        return nums;
    }
}
