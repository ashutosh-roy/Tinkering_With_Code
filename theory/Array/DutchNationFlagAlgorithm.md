## Sort an array of 0s 1s and 2s

### Brute Force Approach :

* Initialise a hashmap with key as elements of the array and value as frequency
* Initialise a fresh array with the keys from hashmap and repeat the values based on given frequency

``` 
    public static void sortColors(int[] nums) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (int num : nums) {
            if (elementCountMap.containsKey(num)) {
                elementCountMap.put(num, elementCountMap.get(num) + 1);
            } else {
                elementCountMap.put(num, 1);
            }
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> eachEntry : elementCountMap.entrySet()) {
            System.out.println("Key = " + eachEntry.getKey() + "Value = " + eachEntry.getValue());
            int value = eachEntry.getValue() + i;
            while (i < value) {
                nums[i] = eachEntry.getKey();
                i++;
            }
        }
    }
```

``` 
 Time complexity :
- O(n) - when the hashmap lookup takes O(1) time
- O(n * log n) - where hashmap lookup takes O(log n) time
- O(n * n) - where all the elements are inside same bucket having same hash values


 
 Space Complexity :
 O(n) - since the hashmap stores n elements
```

### Optimised Approach :

* Use Dutch National Flag
  Algorithm ([reference](https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/))

``` 
public static void sortColorsOptimised(int[] nums) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
```

``` 
 Time complexity :
- O(n)

 Space Complexity :
- O(1) - since no extra storage used
```


