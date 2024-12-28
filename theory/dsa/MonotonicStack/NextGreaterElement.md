#####  Next Greater Element :
nums2 = [1, 3, 2, 5, 4]
nums1 = [1, 5, 2] -> Subset of nums2;

* We'll store the result in RESULT map (with nums1 value as the 'key' and NGE as 'value') and then map it to nums1. 

* 1st iteration :- 
```
We are starting from backwards of the array! 
Index : nums1.length - 1 : nums1[4] = '4'  
Initially stack is empty. SO no NGE found. Hence '-1'
Result :- {4 : -1}
Stack :- [4]
```
* 2nd iteration :-
```
> Index : nums1[3] = '5'
Stack :- [4]
> Pop the elements in the stack until the NGE is found. 
Stack :- []
> No NGE is found. Hence, -1
Result {4 : -1 , 5: -1, }
> Add elements in stack for every iteration
Stack :- [5] 
``` 
* 3rd iteration :-
```
Index : nums1[3] = '2'
Stack :- [5]
> Current Element < Stack TOP. Hence NGE found   
Stack :- [2, 5]
No NGE is found. Hence, -1 

Result {4: -1 , 5: -1, 2: 5, }
```

* 4th iteration :- 
```
Index : nums1[2] = '3'
Stack :- [2, 5]
> Pop element until NGE found 
Stack :- [3, 5]
'5' is NGE found! 

Result {4: -1 , 5: -1, 2 : 5 , 3: 5}
```

##### Pseudocode

```java
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();
        //we are traversing array from backwards
        for(i=nums2.length-1;i>=0;i--) {
            /** 
            * If the stack is empty which always the case at 
            * "nums.length - 1" index, then return -1
            */ 
            if(stack.isEmpty())
            {
                nums2[i] = -1;
            }
            else {
                /**
                 * As long as we not get a NGE, keep removing the element from the array! 
                 */
                while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                /**
                 * If all the elements are out that means no NGE 
                 */
                if(stack.isEmpty()) {
                    result.put(nums2[i], -1);
                }
                /**
                 * If we have an element from Stack that means it is the NGE. 
                 */
                else {
                    result.put(nums2[i], stack.peek());
                }
                // IMPORTANT - 
                // For every iteration keep storing the elements into the stack!
                stack.push(nums2[i]);
            }
        }
        // This is to map the nums2 result into nums1 from the MAP!  
        for(i=0;i<nums1.length;i++) {
            nums1[i] = result.containsKey(nums1[i]) ? result.get(nums1[i]) : -1;
        }
        return nums1;
    }
```