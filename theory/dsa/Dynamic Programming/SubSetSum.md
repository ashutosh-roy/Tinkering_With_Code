


```java
class Solution {

    // Function to determine if a subset with a given sum exists in the array
    static Boolean isSubsetSum(int arr[], int target) {
        // Create a DP table to store results for subproblems.
        // Size: (arr.length + 1) x (target + 1) because:
        // - Rows represent the first 'i' items of the array.
        // - Columns represent target sums from 0 to 'target'.
        Boolean t[][] = new Boolean[arr.length + 1][target + 1];

        // Fill the DP table
        for (int i = 0; i <= arr.length; i++) { // Iterate over all items (including "no items")
            for (int j = 0; j <= target; j++) { // Iterate over all possible target values (0 to target)

                // Base Case 1: If there are no items (i == 0), we can't form a positive target
                if (i == 0) {
                    t[i][j] = false;
                }

                // Base Case 2: If the target is 0 (j == 0), it is always possible (by picking no items)
                if (j == 0) {
                    t[i][j] = true;
                }

                // For cases where i > 0 (i.e., at least one item is considered):
                if (i > 0) {
                    // If the current item's weight (arr[i-1]) is less than or equal to the target sum 'j'
                    if (arr[i - 1] <= j) {
                        // Decision: Include or exclude the current item
                        // 1. Include: Reduce target by item's value and look up t[i-1][j-arr[i-1]]
                        // 2. Exclude: Carry forward the result from t[i-1][j]
                        t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                    } else {
                        // If the item's weight exceeds the target sum, exclude it
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
        }

        // The answer to the original problem is stored in the last cell (bottom-right of the table)
        return t[arr.length][target];
    }
}

```

#### Time & Space Complexity
| **Metric**          | **Standard DP**        | **Space-Optimized DP** |
|----------------------|------------------------|--------------------|
| **Time Complexity**  | \( O(n * target)) | \( O(n * target)) |
| **Space Complexity** | \( O(n * target)) | \( O(target))    |

