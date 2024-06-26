# Tinkering_With_Code

a.k.a my learning journal.

## Table of Contents

### System Design

[Scale from Zero to Million Users](theory/SystemDesign/Alex-Xu-Vol1/chapter01/README.md)

### DSA

Random Necessary Tidbits

* Auxiliary space complexity : refers to the extra space or memory required by an algorithm apart from the input size.
* To reduce the size of number to fit the integer bit range, we use number % MOD where mod = (int) 1e9 + 7;
* Integer.MAX_VALUE -> (2^31-1 = 2147483647)
* Integer.MIN_VALUE -> (-2^31 = -2147483648)

___

### [Recursion](theory/Recursion/Recursion.md)

> TODO :Add generic algorithm style approach in recursion notes for all three patterns.

> Divide and Conquer

* [Count Good Numbers](theory/Recursion/CountGoodNumbers.md)

> Backtracking

* [Combination Sum 1](theory/Recursion/CombinationSum.md)

> Generic Recursion

* [String to Integer (atoi)]()
* [Pow(x, n)](theory/Recursion/pow_x_n.md)
* [Generate All Binary Strings except consecutive ones](https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=generate-binary-strings-without-consecutive-1s)

___

### Arrays

> Famous Problems / One-Ofs

* [Sort Arrays of 0s, 1s and 2s](theory/Array/Sort_Arrays_Of_0s_1s_2s_(Dutch_National_Flag_Algorithm).md)
* [Stock Buy and Sell](src/main/java/com/hobbyprojects/tinkeringwithcode/dsa/arrays/medium/StockBuyAndSell.java)
* [Next Permutation](theory/Array/NextPermutation.md)
* [Pascal's Traingle](/theory/Array/Pascal'sTriangle.md)
* Count reverse pairs
* Count inversions
* Find the Union

> Longest Subarray / Maximum Subarray

* [Longest subarray with given sum K(positives)](theory/Array/Subarray.md)
* [Longest subarray with sum K (Positives + Negatives)](theory/Array/Subarray.md)
* [Longest Consecutive Sequence In An Array](src/main/java/com/hobbyprojects/tinkeringwithcode/dsa/arrays/medium/LongestConsecutiveSequence.java)
* [Find maximum sum for subarray](theory/Array/Subarray.md)

> Matrix Related

* [Set Matrix Zeroes](theory/Array/Matrix.md)
* [Spiral Traversal Of Matrix](theory/Array/Matrix.md)
* [Rotate Image by 90 degrees](theory/Array/Matrix.md)

> Sorting

* Largest Element in an Array
* Check if the array is sorted
* Check if array is sorted and rotated
* Remove duplicates from Sorted array (in-place)
* [Second-Largest Element in an Array without sorting](theory/Array/SecondLargestAndSmallestElementWithoutSorting.md)

> Array Rotation

* Left Rotate an array by one place
* Left rotate an array by D places

> Rearranging Elements

* Move Zeros to end
* [Rearrange elements by sign](theory/Array/RearrangeElementsBySign.md)

> Searching / Finding certain elements or patterns

* Linear Search
* Maximum Consecutive Ones
* Find the number that appears once, and other numbers twice.
* Find missing number in an array
* Find-the-repeating-and-missing-numbers
* Leaders in an array

___

### Sorting

* [Selection Sort](/theory/Sorting/SelectionSort.md)
* [Bubble Sort](/theory/Sorting/BubbleSort.md)
* [Insertion Sort](/theory/Sorting/InsertionSort.md)
* [Merge Sort](theory/Sorting/MergeSort.md)
* [Quick Sort](theory/Sorting/QuickSort.md)

___

### Sliding Window / Two-Pointer Problems

* two-sum-check-if-a-pair-with-given-sum-exists-in-array
* union-of-two-sorted-arrays
* 3-sum-find-triplets-that-add-up-to-a-zero
* 4sum
* Container with most water (two pointer / greedy)

___

### Bit Manipulation -- Low Priority

    * [base 2 and base 10 conversion of a number]()
    * 1s and 2s Compliment
    * Must know tricks in Bit Manipulation
    * Minimum Bit Flips to convert number
    * Power Set
    * Single Number 1
    * Single Number 2
    * Single Number 3
    * XOR of numbers of given range
    * Divide two integers without using multiplication and division operators

### Miscellaneous

##### Java

* Java 8 Features
    * [Streams](/theory/FunctionalProgramming/Streams.md) (In-progress)
      Progress)
    * Optional (TODO)

* Design Patterns (TODO)

##### Templates

* [Boilerplate Code For DSA](templates/BolierplateCode.md)
* [Boilerplate for Notes](templates/v1_TemplateforDSANotes.md)

##### DSA Sheet For Tracking Progress

* [Progress Tracker](https://docs.google.com/spreadsheets/d/1eOiocrhZYlWQHIePjip2fmdI0QLYoRncZ6so_8fcr7g/edit#gid=0)
* [DSA Topics](https://docs.google.com/spreadsheets/d/1eOiocrhZYlWQHIePjip2fmdI0QLYoRncZ6so_8fcr7g/edit#gid=1325411286)
* [Patterns found in DSA problems](https://docs.google.com/spreadsheets/d/1eOiocrhZYlWQHIePjip2fmdI0QLYoRncZ6so_8fcr7g/edit#gid=96114204)

##### Resources to be referred :

https://leetcode.com/discuss/interview-question/5366542/all-leetcode-articles-on-coding-patterns-summarized-in-one-page