## Bubble Sort

### Optimal Force Approach :

* We'll swap the array till maximum element reaches the end.
* The point to remember is that the outer loop will always run till n-1.
* Inner loop will always run till n-i-1. Why ? coz the elements at the end of the array are already swapped.

``` 
static void bubbleSort(int[] ar) {
    int n = ar.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (ar[j] > ar[j + 1]) {
                int temp = ar[j + 1];
                ar[j + 1] = ar[j];
                ar[j] = temp;
            }
        }
    }
    Arrays.stream(ar).forEach(System.out::println);
}
```

##### Time complexity :

``` O(n^2)```

### References:

[Video Reference](https://www.youtube.com/watch?v=HGk_ypEuS24)

[Article reference](https://takeuforward.org/data-structure/bubble-sort-algorithm/)
