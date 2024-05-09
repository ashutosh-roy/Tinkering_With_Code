## Subarray

### Description :

A subarray is a contiguous non-empty sequence of elements within an array.

What is Prefix Sum ?
E.g., For given array, [10, 20, 30, 40], prefix sum is [10, 30, 60, 100]

### Type of Problems :

##### Longest Subarray Scenarios covered :

> Scenario 1 : for arrays with elements having +ve values and 0s, use two pointer

##### Psuedocode

1) Sum must be initialised with the 0th element since the 'end' counter starts with value '1'
2) Condition 1 : Discard the values from prefix sum which make sum > k
3) Condition 2 : By subtracting end & start (+1 since i starts with 0), we get no. of elements in 'k' subarray.
4) Condition 3 : Calculate prefix sum by increasing value of end

##### Source Code

```
public static int subarraySumUsingTwoPointers(int[] nums, int k) {
    int start = 0, end = 0;
    
    // Sum must be initialised with the 0th element since the 'end' counter starts with value '1' 
    int sum = nums[0]; 
    
    int maxLen = 0, n = nums.length;
    while (end < n) {
        
        // Discard the values from prefix sum which make sum > k 
        while (start <= end && sum > k) {
            sum -= nums[start];
            start++;
        }
        
        // By subtracting end & start (+1 since i starts with 0), we get no. of elements in 'k' subarray. 
        if (sum == k) {
            maxLen = Math.max(maxLen, end - start + 1);
        }

        end++;
        // Calculate prefix sum by increasing value of end
        if (end < n) sum += nums[end];
    }

    return maxLen;
}
```

``` 
 Time complexity :
 O(2 * n) - in best case
 
 Space Complexity :
 O(1) - since there was no Data Structure (for e.g., map or array) initialised to solve this.
```

____

> Scenario 2 : for arrays with elements having -ve values, use hashmap with prefix sum

##### Psuedocode

1) Iterate over the elements and calculate prefixSum
2) Condition 1 : Compare and check value of sum and 'k' is equal, if yes, initialise maxLen
3) Condition 2 : If remainder (b/w sum and k) found, it means that there's a subarray existing. Calculate the length of
   subarray (current index 'i' - index where remainder was found)
4) Condition 3 : If sum doesn't exist in map then put into map sum and index (till which prefix sum was found)

##### Source Code

```
 public static int subarraySumUsingHashing(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            //  Calculate prefixSum
            sum += nums[i];
            //  Compare and check value of sum and 'k'
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            //  If remainder (b/w sum and k) found, it means that there's a subarray existing. Calculate the length of subarray (current index 'i' - index where remainder was found) 
             
            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //  If sum doesn't exist in map then put into map sum and index (till which prefix sum was found)
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
```

``` 
 Time complexity :
 O(n * 1) - in best case
 O(n * n) - in worst case when it has to lookup through the entire array
 
 Space complexity :
 O(n) - since maximum prefix sum that can be stored is for 'n' elements
```

### References:

[Video Reference](https://www.youtube.com/watch?v=frf7qxiN2qU&t=1596s)

[For sum with k, Article reference ](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)

[For +ves and -ves, Article reference ](https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/)
