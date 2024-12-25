#### Find an element in Rotated Sorted Array

## Problem Statement
Given a rotated sorted array, find the index of the target element

---
[Solve problem here](https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card)

## Solution Explanation

### **Steps:**
1. **Find the Pivot (Minimum Element Index):**
    - Use binary search to locate the smallest element in the rotated array, which serves as the pivot.

2. **Determine Search Range:**
    - Compare `target` with the smallest and largest values in the array to decide if the target is in the left or right sorted half.

3. **Binary Search:**
    - Perform binary search in the determined range to find the target.

---

### **Algorithm Implementation**
```java
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int minIndex = getMinimumElementIndex(nums);
        System.out.println("Min Index :- " + minIndex);

        // Check if the target is at the pivot
        if (nums[minIndex] == target) {
            return minIndex;
        }

        // Determine the search range
        if (target >= nums[minIndex] && target <= nums[end]) {
            start = minIndex; // Search in the right sorted half
        } else {
            end = minIndex - 1; // Search in the left sorted half
        }

        // Perform binary search in the determined range
        return findElement(nums, start, end, target);
    }

    int findElement(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    int getMinimumElementIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:**
    - Pivot finding: `O(log n)`
    - Binary search: `O(log n)`
    - **Total:** `O(log n)`

- **Space Complexity:** `O(1)` (no additional space used).

---

## Edge Cases
1. **Non-Rotated Array:**
    - Input: `nums = [1, 3]`, `target = 3`
    - Output: `1` (Target found at index `1`).

2. **Array with One Element:**
    - Input: `nums = [1]`, `target = 1`
    - Output: `0` (Target found at index `0`).
    - Input: `nums = [1]`, `target = 2`
    - Output: `-1` (Target not found).

3. **Target at the Pivot:**
    - Input: `nums = [4, 5, 6, 7, 0, 1, 2]`, `target = 0`
    - Output: `4` (Target found at index `4`).

4. **Target in Right Sorted Half:**
    - Input: `nums = [4, 5, 6, 7, 0, 1, 2]`, `target = 1`
    - Output: `5` (Target found at index `5`).

5. **Target in Left Sorted Half:**
    - Input: `nums = [4, 5, 6, 7, 0, 1, 2]`, `target = 5`
    - Output: `1` (Target found at index `1`).

---
