# Minimum Subset Sum Difference Problem

This project provides a solution to the **Minimum Subset Sum Difference** problem using a **Dynamic Programming (DP)** approach. The goal is to divide an array into two subsets such that the absolute difference of their sums is minimized.

---

## Problem Statement
Given an array `nums` of integers, partition the array into two subsets such that the absolute difference between the sums of the subsets is minimized.

### Example:
Input:
```java
nums = {1, 2, 3, 4, 5, 6};
```
Output:
```java
Minimum Difference: 1
```
Explanation:
- Partition: {1, 6, 5} and {2, 3, 4}
- Sum of first subset: 12
- Sum of second subset: 11
- Absolute difference: |12 - 11| = 1

---

## Approach
### Key Ideas
- Use **Dynamic Programming** to solve this as a variation of the Subset Sum Problem.
- Build a DP table `dp[i][j]`, where `dp[i][j]` is `true` if a subset of the first `i` elements can achieve a sum of `j`.
- The closest achievable sum to `totalSum / 2` determines the most balanced partition.

### Steps
1. **Initialize Variables**:
    - Compute the total sum of the array.
    - Set the target sum as `totalSum / 2` (to minimize the difference).

2. **Define and Fill DP Table**:
    - Create a `boolean[][] dp` array of size `(nums.length + 1) x (target + 1)`.
    - Base case: `dp[i][0] = true` (sum of 0 is always achievable).
    - Transition:
        - If not including the current element: `dp[i][j] = dp[i-1][j]`.
        - If including the current element: `dp[i][j] = dp[i-1][j - nums[i-1]]`.

3. **Find the Closest Sum**:
    - Iterate through the last row of the DP table from `target` to `0`.
    - Pick the largest sum that is achievable and calculate the absolute difference.

4. **Return Result**:
    - Return the minimum absolute difference.

---

## Code
```java
class Solution {
    public int minimumDifference(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int target = totalSum / 2;

        // DP array
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // Base cases
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true; // Sum of 0 is always possible
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the closest sum to target
        int min = Integer.MAX_VALUE;
        for (int i = target; i >= 0; i--) {
            if (dp[nums.length][i]) {
                int sum1 = i;
                int sum2 = totalSum - sum1;
                min = Math.min(min, Math.abs(sum1 - sum2));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println("Minimum Difference: " + solver.minimumDifference(nums)); // Output: 1
    }
}
```

---

## Complexity Analysis

### Time Complexity
- The DP table has dimensions `nums.length x (target + 1)`.
- Filling the table requires \(O(n 	imes target)\) operations.
- Finding the closest sum from the last row takes \(O(target)\) operations.

Overall time complexity: **\(O(n 	imes target)\)**, where \(target = 	ext{totalSum} / 2\).

### Space Complexity
- The DP table uses \(O(n 	imes target)\) space.
- The solution ensures correctness by strictly following the subset sum logic.

Overall space complexity: **\(O(n 	times target)\)**.

---