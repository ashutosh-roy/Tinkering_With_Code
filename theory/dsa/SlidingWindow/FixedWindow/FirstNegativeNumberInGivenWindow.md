###### First Negative Number in given window

##### Psuedocode for Brute Force Approach 
1. Use two loops 
  * One to iterate over the array 
  * Second to pick the elements by window of size 'k'
    * assign the -ve element to 'max' 
    * if the -ve element is picked once then donot pick again
    * if the there's no -ve element picked then assign 0
    * store 'max' in a result array of size (n-k+1) i.e., size of the sliding window
    * always reset the value of 'max' (the placeholder for -ve integer) before moving to the next window

```
    public static void printFirstNegativeIntegerBruteForce(long[] ar, long n, long k) {
        int i = 0, j = 0, count = 0;
        long[] resultAsAnArray = new long[(int) (n - k + 1)];

        long max = Integer.MIN_VALUE;
        for (i = 0; i < ar.length; i++) {
            for (j = i; j < k + i; j++) {
                if (j > ar.length - 1) {
                    break;
                }
                if (ar[j] < 0) {
                    max = ar[j];
                    break;
                }
            }
            if (max == Integer.MIN_VALUE) {
                max = 0;
            }
            if (count > resultAsAnArray.length - 1) {
                break;
            }
            resultAsAnArray[count++] = max;
            max = Integer.MIN_VALUE;
        }
        System.out.println("\nUsing Brute Force :- ");
        for (i = 0; i < resultAsAnArray.length; i++) {
            System.out.print(resultAsAnArray[i] + ", ");
        }
    }
```

> TC & SC
``` 
 Time complexity :
 - O(n * k) - where 'n' is number of elements in an array

 Space Complexity :
 - O(n-k+1) - which is total number of windows where  
 'n' is no. of elements in array
 'k' is size of each window  
```

##### Psuedocode for Optimized Approach
1. Iterate over the given array till its length.
2. Increment counter 'j' till it reaches the size of given window 'k'
3. Add index of the -ve integer into the DEQUE (A DS which follows FIFO for insertion /deletion).
4. Once the counter 'j' reaches size of given window 'k', 
   * we check if the DEQUE is empty, it means that there was no -ve number for the given window and we add 0 to the list. 
   * if the DEQUE is not empty, it means that there were -ve integers in the given window. 
     * We add to result the first element in DEQUE 
   * We will remove the last inserted index into DEQUE 
   * Slide the window by 1 i.e., (increase the start of the index ) and the end of index 
    
```
     public static long[] printFirstNegativeInteger(long[] ar, long n, long k)
    {
        int i =0, j=0;
        List<Long> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        while(j < ar.length)
        {
            if(ar[j] < 0)
            {
               deque.offerLast(j);
            }
            if(j-i+1 == k)
            {
                if(!deque.isEmpty()) {
                  result.add(ar[deque.peekFirst()]);
                }
                else {
                  result.add(0L);
                }
                if(!deque.isEmpty() && deque.peekFirst()==i) {
                    deque.pollFirst();
                }
                i++;
            }
            j++;
        }
        System.out.println();
        return toArray(result, "Using Optimised :-");
    }
    public static long[] toArray(List<Long> result, String message)
    {
        long[] resultAsAnArray = new long[result.size()];
        System.out.println(message);
        for(int i =0;i<result.size();i++)
        {
            resultAsAnArray[i] = result.get(i);
            System.out.print(resultAsAnArray[i]+ ", ");
        }
        return resultAsAnArray;
    }
```
> TC & SC
```
Time complexity :
- O(n) - where n is size of array

Space Complexity :
O(k) - Dequeue is used to store 'k' elements at MAX.
```