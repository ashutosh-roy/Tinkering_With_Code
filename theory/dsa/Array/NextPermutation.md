##### Next Permutation :

Lexicographically means in the dictionary order. For e.g., let's try to write [4,5,6] in dictionary order
```
[4,5,6]
[4,6,5]
[5,4,6]
[5,6,4]
[6,4,5]
[6,5,4]
```
##### Pseudocode
1) To identify the breakpoint in simple words:
* Start from the end of the array and move backward.
* Look for the first position i where the number at that position (nums[i] < nums[i + 1]).
* That position i is the breakpoint. 
* Break out of the loop once you get the value!
2) If there's no breakpoint found then reverse the entire array (In this case :- [3,2,1] no increasing elements so directly jump to step4 - [1,2,3])
3) Swap the element at the breakpoint with the next element. Break out of the loop once you get the value!
4) Reverse the right part (breakpoint_index + 1 to n-1) of the array  

Example :
1) Input Array :- [1,2,3]
* breakpoint_index = 1 i.e., after [1]st element - 2, there's an increasing element [2]nd index - 3
* Swap breakpoint_index and next element - [1,3,2]
* Reverse the right part of the array i.e., (breakpoint_index + 1 to n-1) -> from [2]st index till [2]nd index - Hence SKIPPED.

2) Input Array :- [2,3,1]
* breakpoint_index = 0 i.e., after [0]th element - 2, there's an increasing element [1]st index - 3
* Swap breakpoint_index and next element - [3,2,1]
* Reverse the right part of the array i.e., (breakpoint_index + 1 to n-1) -> from [1]st index till [2]nd index, reverse the array - [3,1,2]

##### Source Code

```
    public static void nextPermutation(int[] nums) {
        int i, ind = -1, n = nums.length;
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
            reverseArray(nums, 0, n-1);
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
            reverseArray(nums, ind+1, n-1);
        }
    }
    static void reverseArray(int[] nums, int firstIndex, int lastIndex)
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