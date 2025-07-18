# Floor and Ceil of an element 

Find an floor and ceil element in the given sorted array.
E.g., [1,2,3,4,8,10] & target = 5


Floor = 4 (Largest element smaller than the given target)

Ceil = 8 (Smallest element larger than the given target)

---

### **Algorithm Implementation**
```java
class Solution {

   static int findFloor(int[] arr, int target) {
      // write code here
      int start =0, end = arr.length-1;
      int ceil = -1, floor = -1;
      while(start <= end)
      {
         int mid = start + (end - start)/2;
         if(target < arr[mid]) {
            ceil = mid;
            end = mid - 1;
         }
         else {
            floor = mid;
            start = mid + 1;
         }
      }
      // System.out.println("Floor :- "+floor+"&& Ceil :- "+ceil);
      return floor;
   }
}

```

---

## Complexity Analysis

### **Time Complexity:**
- **Binary Search Base:** The search range is halved in each iteration.
- **Additional Comparisons:** Three constant-time checks are performed for each midpoint.
- **Total Complexity:** `O(log n)`

### **Space Complexity:**
- **Auxiliary Space:** No additional space is used.
- **Total Complexity:** `O(1)`

---