# Search in an Almost Sorted Array

This repository contains a solution for finding a target value in an almost sorted array using a modified binary search approach. An almost sorted array is one in which each element may be misplaced by at most one position (i.e., an element at index `i` could also be at index `i-1` or `i+1`).

---

## Problem Statement
Given an almost sorted array `arr[]` of size `n` and an integer `target`, find the index of the target value in the array. If the target is not present, return `-1`.

**Constraints:**
- The array is almost sorted: each element can be at most one position away from its correct position.
- The algorithm should run in **O(log n)** time complexity.

---

## Solution Explanation
The algorithm is a modified binary search that considers the special properties of an almost sorted array:

### **Steps:**
1. **Calculate Midpoint:**
    - Use binary search to calculate the middle index `mid` of the current range.

2. **Check for Target:**
    - If `arr[mid] == target`, return `mid`.
    - If `arr[mid+1] == target` (and `mid+1` is within bounds), return `mid+1`.
    - If `arr[mid-1] == target` (and `mid-1` is within bounds), return `mid-1`.

3. **Adjust Search Range:**
    - If `target < arr[mid]`, continue searching in the left half by setting `end = mid - 2` (skip the adjacent elements already checked).
    - If `target > arr[mid]`, continue searching in the right half by setting `start = mid + 2`.

4. **Return -1:**
    - If the search range becomes invalid (`start > end`), return `-1` as the target is not present.

---

### **Algorithm Implementation**
```java
class Solution {
    public int findTarget(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check for target at mid and adjacent positions
            if (arr[mid] == target) {
                return mid;
            }
            if (mid + 1 <= end && arr[mid + 1] == target) {
                return mid + 1;
            }
            if (mid - 1 >= start && arr[mid - 1] == target) {
                return mid - 1;
            }

            // Adjust search range
            if (target < arr[mid]) {
                end = mid - 2; // Skip adjacent elements
            } else {
                start = mid + 2; // Skip adjacent elements
            }
        }
        return -1; // Target not found
    }
}
```

---

## Complexity Analysis

### **Time Complexity:**
- **Binary Search Base:** The search range is halved in each iteration.
- **Additional Comparisons:** Three constant-time checks are performed for each midpoint.
- **Total Complexity:** `O(log n)`

### **Space Complexity:**
- **Auxiliary Space:** No additional space is used.
- **Total Complexity:** `O(1)`

---