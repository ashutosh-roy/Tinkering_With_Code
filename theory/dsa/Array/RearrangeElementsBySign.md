```
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, i, j=0, k=0,temp;
        int positives[] = new int[nums.length];
        int negatives[] = new int[nums.length];
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]>=0)
            {
                positives[j++] = nums[i];
            }
            else
            {
                negatives[k++] = nums[i];
            }
        }
        for(i=0;i<n/2;i++)
        {
            nums[2*i] = positives[i];
            nums[(2*i) + 1] = negatives[i];
        }
        return nums;
    }
```

``` 
 Time complexity :
 - O(n) - The outer while loop i.e. the right pointer can move up to index n-1(the last index). 
 - Now, the inner while loop i.e. the left pointer can move up to the right pointer at most. 
 - So, every time the inner loop does not run for n times rather it can run for n times in total. 
 - So, the time complexity will be O(2*N) instead of O(N^2).


 
 Space Complexity :
 O(1) - since there was no Data Structure (for e.g., map or array) initialised to solve this.
```