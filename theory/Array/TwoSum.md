## Two Sum

### Better Approach :

1) Use hashmap to store the element of the array and its index.
2) Calculate ``` rem = eachElement - target ```.
3) If rem exists in the array then return (i ,rem's index)

``` 
    public static int[] twoSumUsingHashMap(int[] ar, int sum) {
        int[] result = new int[2];
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            int rem = sum - ar[i];
            if (elementIndexMap.containsKey(rem)) {
                result[1] = i+1;
                result[0] = elementIndexMap.get(ar[i])+1;
            }
            elementIndexMap.put(ar[i], i);
        }
        return result;
    }
```

##### Time complexity :

``` 
O(N)
 - the loop runs till 'N' to find the TWO sum

O(N^2)  
 - the loop runs till 'N' to find the TWO sum
 - a HashMap has an O(N) lookup due to walking through all entries in the same hash bucket 
 (e.g. if they all have the same hash code). 

O(N * log N) when 
 - the loop runs till 'N' to find the TWO sum 
 - map data structure takes logN time to find an element.

```

##### Space complexity :

``` O(N) as we store N elements in map ```

### Optimal Approach :

Using two pointers algorithm:

``` 
    public static int[] twoSumUsingTwoPointer(int[] ar, int target) {
        int i = 0;
        int j = ar.length - 1;
        int[] result = new int[2];

        while (i < j) {
            if (ar[i] + ar[j] > target) {
                j--;
            }
            if (ar[i] + ar[j] < target) {
                i++;
            }
            if (ar[i] + ar[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }
```

##### Time complexity :

``` 
O(N) + O(N * log N) 
 - The loop will run till 'N' times
 - (N * log N) time taken to sort the array uses TimSort algorithm 
 to sort the array 
```

##### Space complexity :

``` 
O(1) 
 - This remains constant since no data structure used
```

### References:

[Video Reference]()

[Article reference]()
