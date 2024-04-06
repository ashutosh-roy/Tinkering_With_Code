## Selection Sort

### Optimal Force Approach :

* Find the minimum element in the entire array and swap it with the current element
* The point to remember is that the outer loop will always run till n-2.
* Inner loop will always run till n-1

``` 
  public static void selectionSort(int[] ar) {
    int min = 0;
    for (int i = 0; i < ar.length - 1; i++) {
      min = i;
      for (int j = i; j < ar.length; j++) {
        if (ar[j] < ar[min]) {
          min = j;
        }
      }
      int temp = ar[i];
      ar[i] = ar[min];
      ar[min] = temp;
    }
    log.info("After selection sort \n [");
    for (int i = 0; i < ar.length; i++) {
      log.info(ar[i] + ",");
    }
    log.info("]");
  }
```

##### Time complexity :

``` O(n^2)```

### References:

[Video Reference](https://youtube.com/watch?v=HGk_ypEuS24&t=359s)

[Article reference](https://takeuforward.org/sorting/selection-sort-algorithm/)
