#### Optimized Force method which uses Binary Search once
```java
public boolean searchMatrix(int[][] matrix, int target) {
    // Get the dimensions of the matrix: number of rows and columns
    int rows = matrix.length, cols = matrix[0].length;

    // Treat the matrix as a flattened 1D array with indices from 0 to (rows * cols) - 1
    int left = 0, right = (rows * cols) - 1;

    // Perform binary search on the virtual 1D array
    while (left <= right) {
        // Calculate the middle index to prevent overflow
        int mid = left + (right - left) / 2;

        // Map the 1D index to 2D matrix coordinates
        int row = mid / cols; // Determine the row
        int col = mid % cols; // Determine the column

        // Check if the target is found
        if (matrix[row][col] == target) {
            return true;
        }
        // If the current element is greater than the target, search the left half
        else if (matrix[row][col] > target) {
            right = mid - 1;
        }
        // If the current element is less than the target, search the right half
        else {
            left = mid + 1;
        }
    }

    // If we exit the loop without finding the target, return false
    return false;
}

/**
 * Time Complexity:
 * - O(log (m * n)), where m is the number of rows and n is the number of columns.
 *   - Binary search runs on the flattened matrix treated as a 1D array.
 *
 * Space Complexity:
 * - O(1), as no additional space is used apart from variables.
 */


```

#### Brute Force method which uses Binary Search twice 
```java
class Solution {
    /**
     * Searches for a target value in a 2D matrix.
     *
     * The matrix has the following properties:
     * 1. Each row is sorted in ascending order.
     * 2. The first integer of each row is greater than the last integer of the previous row.
     *
     * @param matrix The 2D array of integers.
     * @param target The integer value to search for.
     * @return True if the target exists in the matrix, false otherwise.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Step 1: Binary search to find the potential row containing the target.
        int top = 0, bot = matrix.length - 1, mid;

        while (top <= bot) {
            mid = top + (bot - top) / 2; // Calculate the middle index to avoid overflow.

            /**
             * Check if the target lies within the range of the current row:
             * - If the target is greater than or equal to the first element of the row
             *   and less than or equal to the last element, then the target might be in this row.
             */
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                break; // Found the potential row.
            }
            // If the target is less than the first element of the current row, search the upper half.
            else if (matrix[mid][0] > target) {
                bot = mid - 1;
            }
            // If the target is greater than the last element of the current row, search the lower half.
            else {
                top = mid + 1;
            }
        }

        // Determine the row to search.
        int row = (top + bot) / 2;

        // Step 2: Binary search within the identified row to find the target.
        int left = 0, right = matrix[row].length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2; // Calculate the middle index.

            // Check if the middle element is the target.
            if (matrix[row][mid] == target) {
                return true;
            }
            // If the middle element is less than the target, search the right half.
            if (matrix[row][mid] < target) {
                left = mid + 1; // Move towards larger elements.
            }
            // If the middle element is greater than the target, search the left half.
            else {
                right = mid - 1; // Move towards smaller elements.
            }
        }

        // If we exit the loop without finding the target, return false.
        return false;
    }
}

/**
 * Time Complexity:
 * - O(log m + log n), where m is the number of rows and n is the number of columns.
 *   - Binary search on rows takes O(log m).
 *   - Binary search within the row takes O(log n).
 *
 * Space Complexity:
 * - O(1), as no additional space is used.
 */

```