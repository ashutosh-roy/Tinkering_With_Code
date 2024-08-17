## Subarray

### Description :

A subarray is a contiguous non-empty sequence of elements within an array.

What is Prefix Sum ?
E.g., For given array, [10, 20, 30, 40], prefix sum is [10, 30, 60, 100]

## Type of Problems

### : In Brief :

1. Frequency of Subarray with sum as K 

2. Longest Subarray Scenarios covered :

> Scenario 1 : Find longest subarray with sum 'K' for arrays with elements having +ve values and 0s

- use two pointer

> Scenario 2 : Find longest subarray with sum 'K' for arrays with elements having -ve values,

- use hashmap with prefix sum

____

3. Maximum Sum of Subarray Scenarios covered :

> Scenario 1 : For Maximum Sum K of Subarray,

- use Kadene's algorithm
- Step 1 : keep calculating the max(sum)
- Step 2 : if prefixSum is -ve then make it zero
  ```
  This order is important coz if input is ([-1] i.e., just a -ve number) then
  Output -> 0 (wrong) 
  Output -> -1 (correct) (coz order of steps maintained)
  ```

Solve for edge-cases : [-1], [-3,-1,-1]
____

> Scenario 2 : For Maximum Product K of Subarray

- calculate PRODUCT from 0th and (n-1)th index
- Step 1 : if leftProduct (i.e., from (0 to i)th index is 0 then initialise it as 1)
- Step 2 : if rightProduct (i.e., from (n-1 to 0)th index is 0 then initialise it as 1)
- Step 3 : take max(answer, max(leftProd, rightProd))

Solve for edge-cases : [-1], [-3,-1,-1]
____


> Scenario 3 : For Maximum Absolute Sum of Subarray,

- Step 1 : Find maximum element using Kadene's algo
- Step 2 : Find minimum element using Kadene's algo
- Step 3 : Find absolute values of max and min
- Step 4 : Find MAX of the above two values

Solve for edge-cases : [1,-3,2,3,-4]

____

### : In Depth :

##### Longest Subarray Scenarios covered :

> Scenario 1 : Find longest subarray with sum 'K' for arrays with elements having +ve values and 0s

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

    return max 
```

``` 
 Time complexity :
 - O(2 * n) - The outer while loop i.e. the right pointer can move up to index n-1(the last index). 
 - Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. 
 - So, every time the inner loop does not run for n times rather it can run for n times in total. 
 - So, the time complexity will be O(2*N) instead of O(N^2).


 
 Space Complexity :
 O(1) - since there was no Data Structure (for e.g., map or array) initialised to solve this.
```

____

> Scenario 2 : Find longest subarray with sum 'K', for arrays with elements having -ve values

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

____

##### Maximum Subarray Scenarios covered :

> Scenario 1 : Maximum Sum K of Subarray

##### Psuedocode

* Discard the sum with -ve values
* Find max among sum of existing elements

##### Source Code

```
    public int maxSubArray(int[] nums) {
        int i=0, n=nums.length, sum=0, max = Integer.MIN_VALUE;
        while(i<n)
        {
            sum+=nums[i];
            max = Math.max(max, sum);
            if(sum<0)
            {
                sum=0;
            }
            i++;
        }
        return max;
    }
```

``` 
 Time complexity :
 O(n)
 
 Space complexity :
 O(1) - since we're not using extra space
```

___

> Scenario 2 : Maximum Product K of Subarray

##### Psuedocode

- Step 1 : if leftProduct (i.e., from (0 to i)th index is 0 then initialise it as 1)
- Step 2 : if rightProduct (i.e., from (n-1 to 0)th index is 0 then initialise it as 1)
- Step 3 : take max(answer, max(leftProd, rightProd))

##### Source Code

```
    public int maxProduct(int[] nums) {
        int i, n = nums.length;
        int leftProduct = 1, rightProduct = 1, maxProduct = Integer.MIN_VALUE;
        for(i=0;i<n;i++)
        {
            if(leftProduct == 0)
            leftProduct = 1;
            if(rightProduct == 0)
            rightProduct = 1;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];
            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
```

``` 
 Time complexity :
 O(n)
 
 Space complexity :
 O(1) - since we're not using extra space
```

____

> Scenario 3 : Maximum Absolute Sum K of Subarray

##### Psuedocode

- Step 1 : Find maximum element using Kadene's algo
- Step 2 : Find minimum element using Kadene's algo
- Step 3 : Find absolute values of max and min
- Step 4 : Find MAX of the above two values

##### Source Code

```
    public int maxAbsoluteSum(int[] nums) {
        int i,j, sum=0;
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        int n = nums.length;
        // Find maximum element using Kadene's algo 
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            min = Math.min(min, sum);
            if(sum>0)
            {
                sum = 0;
            }
        }
        sum = 0;
        // Find minimum element using Kadene's algo 
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            max = Math.max(max, sum);
            if(sum<0)
            {
                sum = 0;
            }
        }
        // Find absolute values of max and min
        // Find MAX of the above two values
        return Math.max(Math.abs(max),Math.abs(min));
    }
```

``` 
 Time complexity :
 O(n)
 
 Space complexity :
 O(1) - since we're not using extra space
```

### References:

[Video Reference](https://www.youtube.com/watch?v=frf7qxiN2qU&t=1596s)

[For sum with k, Article reference ](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)

[For +ves and -ves, Article reference ](https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/)

[Get maximum sum from a subarray](https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/)

[maximum-product-any-subarray](https://leetcode.com/problems/maximum-product-subarray/solutions/5180066/maximum-product-subarray-using-two-pointers-and-kadane-s-tc-o-n-sc-o-1/)

[maximum-absolute-sum-of-any-subarray](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/solutions/3002753/simple-java-solution/)