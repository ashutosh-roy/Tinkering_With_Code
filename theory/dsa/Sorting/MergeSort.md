## Merge Sort

- It is based on Divide and Conquer approach.
- It has two parts :-
- mergeSort(int[] ar, int low, int high) : function which divides the array into two equal halves and sorts each halves
- merge(int[] ar, int low, int mid, int high) :
- Stores the elements from the two subarrays (based in the index given by recursive function)
  into a temporary array in a sorted manner
- Add remaining elements into left array
- Add remaining elements into right array
- Put all the elements back into the main array ! (low -> high)

### Optimal Approach :

``` 
public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        // Store the elements from the two subarrays (based in the index given by recursive function) into a temporary array
        while ((left <= mid) && (right <= high)) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // Add remaining elements into left array
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        // Add remaining elements into right array
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // Put all the elements back into the main array !
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
```

##### Time complexity :

``` O(n logn) 
At each step we divide the array so 'log n'
And everytime we divide the array, we have to sort it so 'n'
```

##### Space complexity :

``` O(n) since we are choosing temporary array to store the elements```

### References:

[Video Reference]()

[Article reference]()
