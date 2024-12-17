# 0-1 Knapsack Problem

This document provides an analysis of the time and space complexity of the 0-1 Knapsack problem, considering different approaches.

[Solve the problem here](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card)

## **Approaches**

### **1. Recursive Solution (Without Memoization)**
In the pure recursive solution:
- For each item, there are two choices:
    1. Include the item in the knapsack.
    2. Exclude the item from the knapsack.

#### **Time Complexity**
- **\(O(2^n)\)**  
  Each item results in two recursive calls, leading to exponential growth.

#### **Space Complexity**
- **\(O(n)\)** (due to the recursion stack).  
  The maximum depth of the recursion tree is \(n\) (the number of items).

---

### **2. Recursive Solution with Memoization**
In this approach:
- A 2D table (`t[n+1][capacity+1]`) is used to store intermediate results.
- This avoids redundant recursive calls by storing the results of subproblems.

#### **Time Complexity**
- **\(O(n * capacity)\)**  
  The problem is solved for every combination of \(n\) items and \(capacity+1\) capacities.

#### **Space Complexity**
- **\(O(n * capacity)\)** for the memoization table.
- **\(O(n)\)** for the recursion stack.

>To Remember : For saving Recursion Outputs, wt.length + 1 and capacity + 1 
* is to make sure that the base case where capacity = 0 & weight = 0 is covered!
* is to prevent Array Index Out of Bound exception in case of t[0][someNumber] OR t[someNumber][0]
```java
class Solution {
    // Memoization table
    static int[][] t;

    // Function to return max value that can be put in knapsack of given capacity
    static int knapSack(int capacity, int val[], int wt[]) {
        t = new int[wt.length + 1][capacity + 1];

        // Initialize memoization table with -1
        for (int i = 0; i <= wt.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                t[i][j] = -1;
            }
        }

        // Call recursive function
        return computeMaxValue(capacity, val, wt, wt.length);
    }

    // Recursive function to compute the maximum value
    static int computeMaxValue(int capacity, int val[], int wt[], int n) {
        // Base case: no items left or capacity is 0
        if (capacity == 0 || n == 0) {
            return 0;
        }

        // If already computed, return memoized result
        if (t[n][capacity] != -1) {
            return t[n][capacity];
        }

        // If weight of the current item is less than or equal to capacity
        if (wt[n-1] <= capacity) {
            t[n][capacity] = Math.max(
                    val[n-1] + computeMaxValue(capacity - wt[n-1], val, wt, n-1), // Include item
                    computeMaxValue(capacity, val, wt, n-1) // Exclude item
            );
        } else {
            // Exclude current item
            t[n][capacity] = computeMaxValue(capacity, val, wt, n-1);
        }

        return t[n][capacity];
    }
}

```
---

### **3. Iterative Dynamic Programming (Bottom-Up)**
In the bottom-up DP approach:
- A 2D DP table is constructed iteratively, where `t[i][j]` represents the maximum value attainable with the first \(i\) items and a capacity of \(j\).

#### **Time Complexity**
- **\(O(n * capacity)\)**  
  Each entry in the table is computed in constant time, and there are \(n \times (capacity + 1)\) entries.

#### **Space Complexity**
- **\(O(n * capacity)\)** for the DP table.

```java 
class Solution {
    // Function to return the maximum value that can be put in a knapsack of given capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // Create a DP table with dimensions (number of items + 1) x (capacity + 1).
        // `t[i][j]` represents the maximum value that can be achieved using the first `i` items
        // with a knapsack capacity of `j`.
        int t[][] = new int[wt.length + 1][capacity + 1];
        
        // Iterate over each item (rows of the DP table)
        for (int i = 0; i <= wt.length; i++) {
            // Iterate over each capacity from 0 to the given capacity (columns of the DP table)
            for (int j = 0; j <= capacity; j++) {
                // Base case: If there are no items (`i == 0`) or capacity is 0 (`j == 0`),
                // the maximum value we can achieve is 0.
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } 
                // If the weight of the current item (wt[i-1]) is less than or equal to the current capacity (`j`),
                // we have two choices:
                // 1. Include the current item: Add its value (val[i-1]) and reduce capacity by its weight (`j - wt[i-1]`).
                // 2. Exclude the current item: Retain the maximum value from the previous row (`t[i-1][j]`).
                // Take the maximum of these two choices.
                else if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } 
                // If the weight of the current item (wt[i-1]) exceeds the current capacity (`j`),
                // we cannot include this item, so we take the value from the previous row (`t[i-1][j]`).
                else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // The final cell `t[wt.length][capacity]` contains the maximum value that can be achieved
        // using all items with the given capacity.
        return t[wt.length][capacity];
    }

    // Example main method for testing
    public static void main(String[] args) {
        int val[] = {60, 100, 120}; // Values of the items
        int wt[] = {10, 20, 30};    // Weights of the items
        int capacity = 50;          // Maximum capacity of the knapsack

        // Expected output: 220
        System.out.println(Solution.knapSack(capacity, val, wt));
    }
}

```


---
## **How to identify a Knapsack Problem ?**

* Set of Items with Choices:
  * A list of items where you choose to include or exclude each item.

* Constraints:
  * A maximum limit (e.g., weight, size, or time) restricts your choices.

* Optimization Goal:
  * Maximize value (e.g., profit) or minimize cost (e.g., weight).

* Item Properties:
  * Each item has: A value (profit/benefit). A cost (weight/size).

* Dynamic Nature:
  * The problem often involves overlapping subproblems (solved via Dynamic Programming).

  
---

## **Summary**

| **Approach**                  | **Time Complexity** | **Space Complexity**          |
|--------------------------------|---------------------|--------------------------------|
| Pure Recursive                | \(O(2^n)\)          | \(O(n)\) (recursion stack)    |
| Recursive with Memoization     | \(O(n * capacity)\) | \(O(n * capacity)\) (table) + \(O(n)\) (stack) |
| Iterative DP (Bottom-Up)       | \(O(n * capacity)\) | \(O(n * capacity)\)       |


---
