
> Sliding Window
* A contiguous selection of elements inside either arrays / strings
 
* We keep adding and removing elements to this WINDOW depending on the problem statement

____

#### Identification :-
Question will be to find subarrays / substrings and will have the following details :-
* arrays / strings
* with keywords longest/largest/maximum
* window size can be either 
1) Fixed -
> the window size is given in the problem statement   

> perform some calculations if the window size reaches the given value 

```
Generic Algo :- 
K is the window size 

int start = 0 , end = 0; 
while(end < arr.length) {
    
    // Do some operation until the size is reached
    if(end - start + 1 < k) {
        // Increase the size of from    
    }
    else if(end - start + 1 == k)
    {
        // Move window by 1 place
        start++; end++;
        // Remove the element at start index from the WINDOW & make space to ADD the next element
    }    
}
```

###### Problems Solved :-
1. [Maximum sum of subarray of size K](theory/dsa/SlidingWindow/FixedWindow/MaximumSumSubarray.md)
2. [First -ve number in every window of size K]() 

2) Variable
> Finding the window size gives you the answer

____
