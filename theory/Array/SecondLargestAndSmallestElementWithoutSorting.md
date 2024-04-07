## Second-Largest And Smallest Element Without Sorting

##### Time complexity :

O(n)

### Source Code :

```
    public static int findSecondLargestElement(int[] ar) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i : ar) {
            if (max < i) {
                secondMax = max; // To store the previous value of maximum element
                max = i;
            }
            if (secondMax < i && max != i) { // Need to skip the MAXIMUM element while checking for 2nd MAX element
                secondMax = i;
            }
        }
        return secondMax;
    }

    public static int findSecondSmallestElement(int[] ar) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i : ar) {
            if (min > i) {
                secondMin = min; // To store the previous value of minimum element
                min = i;
            }
            if (secondMin > i && min != i) { Need to skip the MINIMUM element while checking for 2nd MIN element
                secondMin = i;
            }
        }
        return secondMin;
    }
```

### References:

[Article reference](https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/)
