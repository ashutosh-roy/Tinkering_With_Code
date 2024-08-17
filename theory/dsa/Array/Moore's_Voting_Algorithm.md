## Sort an array of 0s 1s and 2s

### Brute Force Approach :

* Initialise a hashmap with key as elements of the array and value as frequency
* Return the element with maximum frequency

```
    public int majorityElement(int[] nums) {
        int ans =1, max = Integer.MIN_VALUE, maxKey = 0;
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for(int i : nums)
        {
            if(!numFreqMap.containsKey(i))
            {
                numFreqMap.put(i, 1);    
            }
            else
            {
                numFreqMap.put(i, numFreqMap.get(i)+1);
            }
        }
        for(Map.Entry<Integer, Integer> eachNum : numFreqMap.entrySet())
        {
            if(max<eachNum.getValue())
            {
                max = eachNum.getValue();
                maxKey = eachNum.getKey();
            }
        }
        return maxKey;
    }
```

```
 Time complexity :
- O(n) 

 Space Complexity :
- O(n) - since we don't store any values
```

### Optimised Approach :

* Use Moore's Voting
  Algorithm ([striver's reference](https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/))

```
    private static int findMajorityElementOptimised(int[] nums) {
        int count = 0, element = nums[0];
        for (int i : nums) {
            count = (i == element) ? count + 1 : count - 1;
            // [3,2,3]
            if (count == 0) {
                element = i;
                count = 1;
            }
        }
        return element;
    }

```

```
 Time complexity :
- O(n)

 Space Complexity :
- O(1) - since no extra storage used
```


