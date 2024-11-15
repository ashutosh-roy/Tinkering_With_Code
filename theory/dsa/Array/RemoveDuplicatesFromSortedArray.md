##### Remove Duplicates from Sorted Array  :

We'll use two pointer algorithm for this :-
```
where, i is the current iterator of the array. (i = 1 initially) 
j, is the index where the unqiue elements are to be placed in the array (j = 0 initially)

How to do in-place swapping of unique elements? 
* if element at ith index is not equal to element at (i-1)th index that means it is unique
* keep adding such elements into jth index of nums and move on!
```
##### Psuedocode
1) Refer [Leetcode Article reference](https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/3676877/best-method-100-c-java-python-beginner-friendly)

##### Source Code

```
    public int removeDuplicates(int[] nums) {
        int i,j;
        for(i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
```

``` 
 Time complexity :
 - O(n) 
 - Traversing the array of length 'n'

 Space Complexity :
 - O(1) : since no extra space used
```


____