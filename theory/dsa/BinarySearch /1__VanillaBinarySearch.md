### Binary Search 
Edge cases to handle
- Integer overflow
- Base conditions of NULL Array
- How are we handling in case of duplicates

[Link to Practice](https://www.geeksforgeeks.org/problems/binary-search-1587115620/1) 

```java
class Solution {
    public int binarySearchFirst(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle empty array
        }
        
        int start = 0, end = arr.length - 1;
        int result = -1; // To store the first occurrence index

        while (start <= end) {
            int mid = start + (end - start) / 2; // Handles Integer Overflow 

            if (k < arr[mid]) {
                end = mid - 1; // Search left half
            } else if (k > arr[mid]) {
                start = mid + 1; // Search right half
            } else {
                result = mid; // Store the index of `k`
                end = mid - 1; // Continue searching in the left half for the first occurrence
            }
        }
        return result; // Return the first occurrence index or -1 if not found
    }
}


```