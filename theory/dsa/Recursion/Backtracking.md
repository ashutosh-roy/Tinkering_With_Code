
> BackTracking
- BT questions are usually to find all the combinations for a given problem.
- Answer is at the leaf nodes of the recursion tree.
- BT = Controlled Recursion + [Pass by reference (Example Code)](src/main/java/com/hobbyprojects/tinkeringwithcode/service/PassByExample.java) + Large number of choices

#### Characteristics of BT problem :-

1) Choices + Decisions -
```
Find subsets of an array where subset sum is 3.
Here based on condition, you'll have to make decision to pick or non-pick elements in an array.
```
2) Size of constraints --- Biggest Indicator
```
In case of BT problems, the size of inputs :-
1<n<10 : Can be single digit
1<n<100 : Can be double digit
```

3) All combinations
```
Find all possible permutations of a given string. 
```

4) Controlled Recursion
```
For e.g., Find subsets of an array where subset sum is 3.
Here we need to add a condition while finding the subsets.

```
5) Large Number of choices
```
Compared to a normal recursive problem, 
a BT problem will have large number of choices 
(given by the recursion tree) 
```


* Don't be greedy
```
Input constraint for a greedy problem
is far more different than that of a BT problem. 
```

#### Generic Pseudocode for BT problem :-
To revise algorithm :  **[visit this](https://www.youtube.com/watch?v=M5D3KUKH3gE&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=4)**
```
Steps 
1. Base case 
2. For Loop to repeatedly call recursion 
3. A condition to ignore cases which aren't relevant to the problem
4. Make changes to variable 
5. Call recursive function 
6. Revert changes from the variable 
```
```
    backTrack( <inputs> )
    {
        // Base Case 
        if(isSolved()) 
        {
            //Print / Save the combination
            return;
        }
        
        // Now since the number of choices are large, 
        // hence we use FOR Loop 
        // to invoke recursion to get each combination   
        
        for (eachChoice in all CHOICES)
        {
            // Since there are a lot choices,  
            // we are interested in those choices
            // which will give us the answer! 
            
            if(isValid() == true) 
            {
                change in V
                backTrack( <inputs> );
                revert changes in V 
            }
        }
    }
```

<br>

_____

#### Types of BT problem :-
- [Permutation of string (distinct and repeated)](src/main/java/com/hobbyprojects/tinkeringwithcode/dsa/recursion/medium/PermutationOfString.java)
- Largest number in kth swaps
- N digits with some digits in an increasing order
- Rat in a maze problem
- Wand Break
- Palindrome Partitioning
- Combination Sum
- Sudoku
- N-Queens
- Prove letter digits
- M coloring problem
