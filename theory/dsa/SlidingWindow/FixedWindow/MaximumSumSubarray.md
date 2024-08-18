###### Maximum Sum of Subarray for size K 

```
    static int getMaximumSubarraySum(int[] arr, int k)
    {
        int i = 0, j = 0;
        int sum = 0, max =0;
        while(j < arr.length)
        {
            sum = sum + arr[j];
            if((j-i+1) < k) {
                j++;
            }
            else if((j-i+1) == k)
            {
                max = Math.max(max, sum);
//              Remove first element from the Sliding Window to make space to add the next element
                sum = sum - arr[i];
//              increase the start and end indexes to move the window forward
                i++;
                j++;
            }
        }
        return max;
    }
```