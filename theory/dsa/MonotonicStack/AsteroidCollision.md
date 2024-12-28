Asteroid Collision :- 

##### Approach :- 
1. If there are +ve asteroids we can add them to the stack without any issues, since they won't collide.
2. For -ve, asteroids, we need to check
*  if current asteroid in stack > 0 (which means +ve) && less than incoming -ve asteroid,
this means it is smaller in size compared to incoming asteroid,
then collision happens and the current asteroid is removed.

* If the stack is empty or the top is negative, the current asteroid survives,
so push into stack

* if the current asteroid in stack is equal to incoming -ve asteroid, then they collide.
which means pop the current asteroid from the stack.


```java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack to keep track of surviving asteroids
        Stack<Integer> st = new Stack<>();
        
        // Iterate through each asteroid in the array
        for (int i = 0; i < asteroids.length; i++) {
            // Case 1: Current asteroid is positive
            if (asteroids[i] > 0) {
                // Positive asteroids are added to the stack since they move right and can't collide
                st.push(asteroids[i]);
            } else {
                // Case 2: Current asteroid is negative
                // Check for collisions with positive asteroids in the stack
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroids[i]) {
                    // The positive asteroid at the top of the stack is smaller in magnitude
                    // It gets destroyed by the current negative asteroid
                    st.pop();
                }
                
                // After resolving smaller positive asteroids, check the state of the stack
                if (st.isEmpty() || st.peek() < 0) {
                    // If the stack is empty or the top is negative, the current asteroid survives
                    st.push(asteroids[i]);
                }
                
                // Special case: Both asteroids have equal magnitude
                if (!st.isEmpty() && st.peek() == -asteroids[i]) {
                    // Both asteroids destroy each other
                    st.pop();
                }
            }
        }

        // Prepare the result array
        int[] result = new int[st.size()];
        int k = st.size() - 1; // Start from the end of the result array
        
        // Populate the result array by popping elements from the stack
        while (!st.isEmpty()) {
            result[k--] = st.pop();
        }

        return result; // Return the final state of surviving asteroids
    }
}


```

```
Complexity Analysis:
Time Complexity: O(n)
Each asteroid is pushed and popped from the stack at most once, leading to linear complexity.

Space Complexity: O(n)
The stack holds the surviving asteroids.
```