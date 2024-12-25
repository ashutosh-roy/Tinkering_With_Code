# Count Number of Subsequences

## Problem Description
Given an integer array `nums` and an integer `target`, count the number of **non-empty subsequences** such that the sum of the **minimum** and **maximum** element of the subsequence is less than or equal to `target`. Since the answer may be very large, return it **modulo** \(10^9 + 7\).

## Solution
### Approach
1. **Sort the Array**:
    - Sorting helps efficiently identify valid subsequences using a two-pointer approach.

2. **Two-Pointer Technique**:
    - Use two pointers (`start` and `end`) to traverse the array.
    - For a pair of indices `(start, end)`, if the sum of `nums[start] + nums[end]` is less than or equal to `target`, then all subsequences that include `nums[start]` and any subset of elements between `start` and `end` are valid.
    - Increment the `start` pointer when a valid pair is found; decrement the `end` pointer otherwise.

3. **Precompute Powers of 2**:
    - Precompute powers of 2 modulo \(10^9 + 7\) to count the number of subsequences efficiently.

4. **Modulo Operation**:
    - Since the result can be very large, return the count modulo \(10^9 + 7\).

### Code
```java
import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        Arrays.sort(nums); // Sort the array to enable two-pointer traversal
        int start = 0, end = nums.length - 1;
        int result = 0;

        // Precompute powers of 2 modulo MOD
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        while (start <= end) {
            if (nums[start] + nums[end] <= target) {
                // All subsequences formed by nums[start] and any subset of nums[start + 1]...nums[end] are valid
                result = (result + power[end - start]) % MOD;
                start++; // Move start to try including the next element
            } else {
                end--; // Move end to try a smaller element
            }
        }

        return result;
    }
}
```

## Complexity Analysis

### Time Complexity
1. **Sorting**:
    - Sorting the array takes \(O(n \log n)\), where \(n\) is the length of the array.

2. **Precomputing Powers of 2**:
    - Precomputing powers of 2 for all possible lengths takes \(O(n)\).

3. **Two-Pointer Traversal**:
    - Each pointer (`start` and `end`) moves at most \(n\) steps, resulting in \(O(n)\).

**Total Time Complexity**:
\[
O(n \log n) + O(n) + O(n) = O(n \log n)
\]

### Space Complexity
1. **Power Array**:
    - An array of size \(n\) is used to store precomputed powers of 2, requiring \(O(n)\) space.

2. **Sorting Auxiliary Space**:
    - Sorting requires \(O(n)\) auxiliary space for mergesort or quicksort.

3. **Other Variables**:
    - A constant amount of space is used for pointers and intermediate computations.

**Total Space Complexity**:
\[
O(n) + O(n) = O(n)
\]

## Example
### Input
```java
nums = {3, 5, 6, 7};
target = 9;
```

### Output
```java
4
```

### Explanation
- Valid subsequences are: `[3]`, `[3, 5]`, `[3, 6]`, `[3, 5, 6]`.
