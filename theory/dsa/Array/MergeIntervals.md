```java 

class Solution {
    /**
     * Merges overlapping intervals from the input array.
     *
     * @param intervals 2D array where each element represents an interval [start, end].
     * @return A 2D array containing the merged intervals.
     */
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on their start times.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store merged intervals.
        List<int[]> merged = new ArrayList<>();

        // Step 3: Initialize the previous interval with the first interval in the sorted list.
        int[] prev = intervals[0];

        // Debugging purpose: Print the initial interval
        System.out.print(Arrays.toString(prev));

        // Step 4: Iterate through the rest of the intervals.
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            /*
             * Check if the current interval overlaps with the previous interval:
             * - If the start time of the current interval is less than or equal to
             *   the end time of the previous interval, they overlap.
             */
            if (curr[0] <= prev[1]) {
                // Merge the intervals by updating the end time of the previous interval.
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                // If the intervals do not overlap, add the previous interval to the result list.
                merged.add(prev);

                // Update the previous interval to the current interval.
                prev = curr;
            }
        }

        // Add the last interval to the result list.
        merged.add(prev);

        // Step 5: Convert the list of merged intervals back into a 2D array.
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = merged.get(i);

            // Debugging purpose: Print the merged interval
            System.out.println(Arrays.toString(result[i]));
        }

        return result;
    }
}

/**
 * Space Complexity: O(n)
 * - The additional space is used to store the merged intervals in the List.
 *
 * Time Complexity: O(n log n)
 * - Sorting the intervals array takes O(n log n).
 * - Iterating through the intervals takes O(n).
 * - Therefore, the overall complexity is O(n log n).
 */

```