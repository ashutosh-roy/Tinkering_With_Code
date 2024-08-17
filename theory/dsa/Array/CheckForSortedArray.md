## Check for Sorted Array

### Brute Force Approach :

* If the array is sorted,
* the maximum element will either be at the start of the array (if it is sorted in DESC order)
* or at the end of the array (if it is sorted in ASC order)

``` 
private static Boolean checkIfArrayIsSorted(int[] ar) {
        int max = Integer.MIN_VALUE;
        int indexForMax = 0;
        for (int i = 0; i < ar.length; i++) {
            if (max < ar[i]) {
                max = ar[i];
                indexForMax = i;
            }
        }
        return indexForMax == 0 || indexForMax == ar.length - 1;
    }
```