## Combination Sum 1

### Brute Force Approach :

1. We'll start with picking and non picking the element
2. Draw the recursion tree of all those possibilities
3. if still confusing,
   refer [Striver's Video Soln.](https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=10&ab_channel=takeUforward)

##### Things to keep in mind:

* if the target != 0 for the selected combination, then pop out the last element from selected combination

##### Time complexity :

``` Insert time complexity here```

### Optimal Approach :

1. The recursion tree is formed when by picking and unpicking the same element for checking the sum with target
2. If the element is picked then reduce the target
3. If at the end of picking the same repeated element the target is not 0 then the set is incorrect and it should be
   terminated.
4. Now let's move to unpicking side of things

``` 
 public static void combinationSum(int index, int[] ar, int target, List<List<Integer>> combinedResult, List<Integer> eachResult) {
     if (index == ar.length) {
         if (target == 0) {
             System.out.println("Each Result after target match = " + eachResult.toString());
             combinedResult.add(new ArrayList<>(eachResult));
         }
         return;
     }
     if (ar[index] <= target) {
         eachResult.add(ar[index]);
         System.out.println("Each Result = " + eachResult);
         System.out.println("Target = " + (target - ar[index]));
         combinationSum(index, ar, target - ar[index], combinedResult, eachResult);
         eachResult.remove(eachResult.size() - 1);
     }
     combinationSum(index + 1, ar, target, combinedResult, eachResult);
 }
```

##### Time complexity :

``` 
When interviewer asks tell exponential and then mention below answer :-
O(2^t * k) : where
t is target 
k is average length of combinations
Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)

Why not (2^n) but (2^t) (where n is the size of an array)?

Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element. 
```

##### Space complexity :

``` 
(k*x) : where 
k is the average size of the combinations 
x is the number of combinations

```

### References:

[Video Reference]()

[Article reference]()
