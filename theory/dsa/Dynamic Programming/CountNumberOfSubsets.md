[Solve the problem here](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)

---

## **Code Implementation**

```java
public class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;

        // DP table: dp[i][j] stores count of subsets using first i elements to achieve sum j
        int dp[][] = new int[n + 1][target + 1];

        // Fill the DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // Base Case: Sum = 0 -> Only one subset exists (empty subset)
                if (j == 0) {
                    dp[i][j] = 1;
                }
                // Base Case: No elements and target > 0 -> No subset is possible
                else if (i == 0) {
                    dp[i][j] = 0;
                }
                // Current element can be included
                else if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
                // Current element cannot be included
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // Final answer: Total count of subsets for target sum
        return dp[n][target];
    }
}
```

---

## **Complexity Analysis**

| Metric             | Complexity         |
|--------------------|--------------------|
| **Time Complexity** | O(n \* target)     |
| **Space Complexity**| O(n \* target)     |

- **Time Complexity:** The DP table is of size `n x target`, and each cell is processed once.
- **Space Complexity:** The 2D DP table requires `O(n x target)` space.

---