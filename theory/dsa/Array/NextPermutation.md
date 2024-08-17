##### Next Permutation :

##### Psuedocode

Lexicographically means in the dictionary order. For e.g., let's try to write [4,5,6] in dictionary order

```
[4,5,6]
[4,6,5]
[5,4,6]
[5,6,4]
[6,4,5]
[6,5,4]
```

##### Source Code

```
class Solution {
    public void nextPermutation(int[] nums) {
        int i, j, ind = -1, n = nums.length;
        // For e.g., 1, 3, 2 
        // Step 1 : Find the break point after which all the elements are in increasing order
        for(i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind = i;
                break;
            }
        }
        
        // If no breakpoint found then
        if(ind == -1)
        {
            int[] arr = new int[nums.length];
            nums = reverseArray(nums, 0, n-1);
        }
        else
        {
            // For e.g., 1, 3, 2 -> 2, 3, 1
            // Step 2 : Swap the index with the next element
            for(i=n-1;i>ind;i--)
            {
                if(nums[i]>nums[ind])
                {
                    int temp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = temp;
                    break;
                }
            }
            // For e.g., 2, 3, 1 -> 2, 1, 3
            // Step 3 : Reverse the right part of the array 
            nums = reverseArray(nums, ind+1, n-1);
        }
    }
    int[] reverseArray(int nums[], int firstIndex, int lastIndex)
    {
        int temp = 0;
        while(firstIndex<lastIndex)
        {
            temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
        return nums;
    }
}
```

``` 
 Time complexity :
 - O(3*n) 
 - Finding the breakpoint
 - Finding the reverse of elements
 - Finding the next greatest element  

 Space Complexity :
 - O(1) : since no extra space used
```

[Video Reference](https://www.youtube.com/watch?v=JDOXKqF60RQ)

[Next Permutation Article reference ](https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/)

____