## Insertion Sort

### Approach :

1. Pick an element from the right.
2. Keep swapping it with the elements in the left till possible.
3. Outer loop : (n-1)
4. Inner loop : runs only till 1st index in order to compare b/w left and right element

```   
static void insertionSort(int[] ar) {
    for (int i = 0; i < ar.length-1; i++) {
        int j = i;
        /*
         * ar[j] - Element at the right
         * ar[j-1] - Element at the left
         * */
        while (j > 0 && ar[j - 1] > ar[j]) {
            int temp = ar[j - 1];
            ar[j - 1] = ar[j];
            ar[j] = temp;
            j--;
        }
    }
    log.info("Output of insertion sort :- ");
    Arrays.stream(ar).forEach(System.out::println);
}
```

##### Time complexity :

``` O(n^2) ```

##### Space complexity :

``` O(1) : Constant```

### References:

[Video Reference](https://www.youtube.com/watch?v=HGk_ypEuS24)

[Article reference](https://takeuforward.org/data-structure/insertion-sort-algorithm/)
