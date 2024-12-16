## What is DP 

DP = Recursion + Storage 

Storage can be done either 
* memoization or 
* bottoms-up approach.


## Key Characteristics of a DP Problem

### 1. Optimal Substructure
A problem exhibits an **optimal substructure** if an optimal solution to the entire problem can be constructed from optimal solutions to its subproblems.

- **Example**:
    - **Shortest path in a graph**: The shortest path from `A` to `C` through `B` is the sum of the shortest path from `A` to `B` and `B` to `C`.

### 2. Overlapping Subproblems
The problem involves solving the **same subproblem multiple times**, and these results can be stored (memoized) and reused.

- **Example**:
    - **Fibonacci sequence**: Calculating `Fib(n)` requires `Fib(n-1)` and `Fib(n-2)`, which are also needed for `Fib(n-2)`.

---

## Steps to Identify a DP Problem

Here are refined steps to check if a problem can be solved using DP:

### 1. Understand the Problem
- Is the input structured in a way that allows breaking it down into smaller subproblems?

### 2. Define Choices
- What decisions or choices can be made at each step?
- How do these influence the state of the problem?

### 3. Check for Overlapping Subproblems
- If the same subproblem is solved repeatedly, memoization or a bottom-up approach can avoid redundant calculations.
Example 
```
wt = {1, 2, 3}, capacity = 5
knapsack(3, 5)  // Decision: Include or exclude item 3 (wt[2] = 3, val[2] = 30)
    ├── knapsack(2, 5)  // Exclude item 3
    │       ├── knapsack(1, 5)  // Exclude item 2 (wt[1] = 2)
    │       └── knapsack(1, 3)  // Include item 2 (remaining capacity: 5 - wt[1] = 3)
    └── knapsack(2, 2)  // Include item 3 (remaining capacity: 5 - wt[2] = 2)
            ├── knapsack(1, 2)  // Exclude item 2 (wt[1] = 2)
            └── knapsack(1, 0)  // Include item 2 (remaining capacity: 2 - wt[1] = 0)
```
### 4. Check for Optimal Substructure
- Verify if solving smaller subproblems optimally guarantees the optimal solution to the overall problem.

### 5. Design a State Representation
- Represent the problem in terms of states and transitions between states.
- **Example**: For the knapsack problem, the state can be defined as `dp[i][w]`, where:
    - `i` is the number of items considered.
    - `w` is the remaining weight capacity.

## When It Might NOT Be a DP Problem
* If choices are independent: If decisions at each step don't depend on others, a greedy or divide-and-conquer approach might be more suitable.
* If no overlapping subproblems: Problems like quicksort or mergesort don't benefit from DP because subproblems don't overlap.


## Different Approaches to solving DP 
1. Recursion + Memoization  
```
Recursion + Matrix created to store the output of the Recursive Call
Size of the matrix is dependent on the changing values. 
For e.g., in case of Knapsack, the changing values are index of the weight array & the capacity of the bag!
```
2. Bottom-Up approach (the advantage of this over memoization is, it doesn't lead to a scenario where recursion stack overflows!)
```
> Just have the table & omit the Recursive call totally!
> This is called Bottom-Up because we create the MATRIX from the base case!
```


## Variations

* 0-1 Knapsack
  * Subset Sum
  * Equal Sum Partition
  * Count of Subset Sum
  * Minimum Subset Sum Diff.
  * Target Sum
* Unbounded Knapsack
* Fibonacci
* LCS
* LIS
* Kadene's Algo
* Matrix Chain Multiplication
* DP on Trees
* DP on Grid
* Others


