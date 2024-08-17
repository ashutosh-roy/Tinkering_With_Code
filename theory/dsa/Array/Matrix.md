## Matrix

### Description :

A 2D Array

## Type of Problems

### : In Brief :

##### Set Zeroes :

Steps :
____

##### Spiral Traversal of matrix :

- to be added

  ```
    Add example if needed
  ```

Solve for edge-cases :

____

##### Rotate Matrix Image by 90 degrees :

- to be added

  ```
    Add example if needed
  ```

Solve for edge-cases :

____

### : In Depth :

##### Set Zeroes :

##### Psuedocode for Optimized Approach
1) to be added

##### Source Code
```

```
``` 
 Time complexity :
 - O(2 * (m * n)) - where m is row_size and n is column_size

 Space Complexity :
 O(n) + O(m) - since there were row (with size m) & col (with size n) array used 
```
____

##### Psuedocode for Better Approach 
1) Let's initialise row array (with size m) and col array (with size n) 
2) We'll use these arrays to capture the indexes which should ideally be 0 
3) We'll mark such indexes with '1' in row array and col array
4) Iterate over the matrix again 
5) Whenever, there's a value '1 ' found for row or col array found, mark same indexes of array with 0.  

##### Source Code

```
  public static void setZeroesBetter(int[][] ar)
  {
    int i,j;
    int m=ar.length;
    int n=ar[0].length;

    int row[] = new int[m];
    int col[] = new int[n];

    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        if(ar[i][j] == 0)
        {
          // mark rows
          row[i] = 1;

          // mark columns
          col[j] = 1;
        }
      }
    }
    // For all those indexes which were supposed to be 0
    // let's mark it as 0 in the actual array
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        if(row[i]==1 || col[j]==1)
        {
          ar[i][j] = 0;
        }
        System.out.print(ar[i][j]+", ");
      }
      System.out.println();
    }
  }
```

``` 
 Time complexity :
 - O(2 * (m * n)) - where m is row_size and n is column_size

 Space Complexity :
 O(n) + O(m) - since there were row (with size m) & col (with size n) array used 
```

##### Psuedocode for Brute Force

1) Iterate over each row and column
2) Mark the rows separately and columns seperately with a non-zero number (coz marking with zero directly will affect the rows and columns which aren't meant to affected)
```
Dry run this later if you don't understand.
```
3) Iterate over the rows and columns again and mark the non-zero elements with zero


Disadvantages : <br>
- It will mark those non-zero elements as 0 (which were not meant to be) if the input array contains the number that you're trying to mark the 0th rows / columns with.

```
Dry run this later if you don't understand.
For this sample input the logic 

[[-1, 1, 1], [1, 1, 0], [1, 1, 1]] 
expected - [[-1, 1, 0], [0, 0, 0], [1, 1, 0]]
actual - [[0, 1, 0], [0, 0, 0], [1, 1, 0]]
```
- Time Complexity is higher 
##### Source Code

```
  public static void setZeroesBrute(int[][] nums) {
    int i, j, m = nums.length, n = nums[0].length;
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        if(nums[i][j]==0)
        {
          markRows(nums, m, j);
          markColumns(nums, n, i);
        }

      }
      System.out.println();
    }
    System.out.println("Set Zeroes Brute Output :- ");
    for(i=0;i<m;i++)
    {
      for(j=0;j<n;j++)
      {
        if(nums[i][j]== -1)
        {
          nums[i][j] = 0;
        }
        System.out.print(nums[i][j]+", ");
      }
      System.out.println();
    }
  }
  
```

``` 
 Time complexity :
  O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
  Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
  Another O(N*M) is taken to mark all the cells with -1 as 0 finally.


 
 Space Complexity :
 O(1) - since there was no Data Structure (for e.g., map or array) initialised to solve this.
```

____

##### Spiral Traversal Of Matrix :

##### Psuedocode

1) to be added

##### Source Code

```

```

``` 
 Time complexity :
 - O(2 * n) - to be added


 
 Space Complexity :
 O(1) - to be added
```

____

##### Spiral Traversal Of Matrix :

##### Psuedocode

1) to be added

##### Source Code

```

```

``` 
 Time complexity :
 - O(2 * n) - to be added


 
 Space Complexity :
 O(1) - to be added
```

____

##### Rotate Image by 90 degrees :

##### Psuedocode

1) to be added

##### Source Code

```

```

``` 
 Time complexity :
 - O(2 * n) - to be added


 
 Space Complexity :
 O(1) - to be added
```

____

### References:

[Set Zeroes](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)

[Spiral Traversal Of Matrix](https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/)

[Rotate image by 90 degrees](https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/)
