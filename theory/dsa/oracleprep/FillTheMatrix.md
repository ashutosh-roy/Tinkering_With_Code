# Minimum Iterations to Fill a Matrix Using Manhattan Distance

## Problem Statement

Given a matrix with dimensions \( N \times M \), entirely filled with zeroes except for one position at coordinates \( X, Y \) containing `1`, find the minimum number of iterations required to fill the entire matrix with ones.

In one iteration, `1` can be filled in the 4 neighboring elements of a cell containing `1`.

---

## Algorithm

To solve this efficiently, we use the **Manhattan distance approach**. The key insight is that the matrix is filled in "layers" from the starting position. The farthest cell (in terms of Manhattan distance) determines the number of iterations.

### Manhattan Distance Formula

The distance between two points (x1, y1) and (x2, y2) is given by:
Distance = |x1 - x2| + |y1 - y2|


For a matrix, the farthest cells are the corners:
- **Top-left corner**: \((0, 0)\)
- **Top-right corner**: \((0, M-1)\)
- **Bottom-left corner**: \((N-1, 0)\)
- **Bottom-right corner**: \((N-1, M-1)\)

---

## Code Implementation

```java
public class MinimumIterations {

    public static int minIterations(int n, int m, int x, int y) {
        // Adjust coordinates to 0-based indexing
        x--; 
        y--;

        // Compute Manhattan distances to the four corners of the matrix
        int topLeft = x + y; // (0, 0)
        int topRight = x + (m - 1 - y); // (0, m-1)
        int bottomLeft = (n - 1 - x) + y; // (n-1, 0)
        int bottomRight = (n - 1 - x) + (m - 1 - y); // (n-1, m-1)

        // Return the maximum of these distances
        return Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
    }

    public static void main(String[] args) {
        // Example inputs
        int n = 4; // Number of rows
        int m = 4; // Number of columns
        int x = 1; // Starting row (1-based)
        int y = 2; // Starting column (1-based)

        // Call the function and print the result
        int result = minIterations(n, m, x, y);
        System.out.println("Minimum iterations to fill the matrix: " + result);
    }
}
```
## Explanation

1. **Adjust Coordinates**:  
   Convert the 1-based coordinates \((X, Y)\) to 0-based indexing for easier computation. This can be done by subtracting 1 from both \(X\) and \(Y\):


2. **Compute Manhattan Distances**:  
   The Manhattan distance is computed from the starting position to each of the four corners of the matrix:
- **Top-left corner**: The distance is \(X + Y\).
- **Top-right corner**: The distance is \(X + (M - 1 - Y)\).
- **Bottom-left corner**: The distance is \((N - 1 - X) + Y\).
- **Bottom-right corner**: The distance is \((N - 1 - X) + (M - 1 - Y)\).

3. **Find the Maximum Distance**:  
   The minimum number of iterations required to fill the matrix is the maximum of these distances, since the filling will take as long as it takes to fill the farthest corner.

---
X = X - 1, Y = Y - 1

## Example Walkthrough

### Input:
- \( N = 4, M = 4, X = 1, Y = 2 \) (1-based indexing)

### Step-by-Step Calculation:
1. **Convert to 0-based indexing**:
X = 1 - 1 = 0, Y = 2 - 1 = 1

2. **Compute distances**:
- **Top-left corner**: \(0 + 1 = 1\)
- **Top-right corner**: \(0 + (4 - 1 - 1) = 2\)
- **Bottom-left corner**: \((4 - 1 - 0) + 1 = 4\)
- **Bottom-right corner**: \((4 - 1 - 0) + (4 - 1 - 1) = 5\)

3. **Maximum distance**:
Maximum Distance = max(1, 2, 4, 5) = 5
### Output:
Minimum iterations to fill the matrix: 5

---

## Complexity Analysis

- **Time Complexity**: \( O(1) \)  
  The computation involves a constant number of arithmetic operations (4 distances and a maximum calculation).

- **Space Complexity**: \( O(1) \)  
  No additional space is required beyond a few variables for storing intermediate results.
