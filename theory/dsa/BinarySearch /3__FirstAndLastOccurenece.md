### First and last occurrence of number
[Solve problem here ](https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/)

```java
class Solution {
    private int getOccurrenceFor(int[] nums, int target, boolean findFirst) {
        int result = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // Target found
                result = mid;
                if (findFirst) {
                    end = mid - 1; // Narrow search to the left for first occurrence
                } else {
                    start = mid + 1; // Narrow search to the right for last occurrence
                }
            }
        }

        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int firstOccurrence = getOccurrenceFor(nums, target, true);  // Find first occurrence
        int lastOccurrence = getOccurrenceFor(nums, target, false); // Find last occurrence

        return new int[] { firstOccurrence, lastOccurrence };
    }
}

```