##### Search Insert Position / Binary Search basics

Binary Search
**Pre-requisites**
* The array should be sorted 
* Access to any element of the data structure should take constant time.

##### Source Code

```
 public int searchInsert(int[] nums, int target) {
    int mid = 0, start = 0, end = nums.length; 
    int indexFound = 1;
    while(start < end) 
    {
        mid  = start + (end-start)/2;
        if(target==nums[mid]) {
            return mid;
        }
        if(target > nums[mid]) {
            start = mid + 1;
        }
        if(target < nums[mid]) {
            end = mid - 1;
        }
 
    }
    return start;
}
```

``` 
 Time complexity :
 - O(log n) 

 Space Complexity :
 - O(1) : since no extra space used
```


____