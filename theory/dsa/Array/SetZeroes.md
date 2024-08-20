## Set Zeroes

##### Psuedocode for Brute Force

1) Take a new array and store all the ith and jth index of elements with 0. Let's call this zeroTracker

2) Now we'll create 3 nested loops with first loop iterating over 'zeroTracker' array and then use remaining two loops to iterate over rows and columns of matrix.

3) If i and j index for current element is present in zeroTracker then mark all the rows with [i][j] as 0.


##### Source Code

```
 class Solution {
    public void setZeroes(int[][] matrix) {
        int i, j, k, count=0;
        int[][] zeroTracker = new int[matrix.length * matrix[0].length][2];
        for(i=0;i<matrix.length;i++)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    zeroTracker[count][0] = i;
                    zeroTracker[count][1] = j;
                }
                else
                {
                    zeroTracker[count][0] = -1;
                    zeroTracker[count][1] = -1;
                }
                count++;
            }
        }
        for(k=0; k<zeroTracker.length; k++)
        {
            System.out.println(zeroTracker[k][0]);
            System.out.println(zeroTracker[k][1]);
        }


        for(k=0;k<zeroTracker.length;k++)
        {
            for(i=0;i<matrix.length;i++)
            {
                for(j=0;j<matrix[0].length;j++)
                {
                    if(zeroTracker[k][0]==i || zeroTracker[k][1]==j) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
```

``` 
 Time complexity :
  O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
  Reason: Firstly, we are traversing the matrix to find the cells with the value 0. It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1. This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
  Another O(N*M) is taken to mark all the cells with -1 as 0 finally.


 
 Space Complexity :
 O(2*m*n) - zeroTracker array created occupies this space 
```

____

##### Psuedocode for Optimized Approach
Two nested i and j loops to :-
* The idea is to use first row and first column as the space for marking the elements as 0s and 1s
* col0 is a variable that maintains "What value to be updated in 0th column". Why ? row and col will have same [0,0] index.  
* Update rows and columns with 0 where ever you see matrix[i][j] is 0. 

Two nested i and j loops to :-
* Update the values from [1, m (row_size)] and [1, n (column_size)] with 0

Assign correct value to row0 
* if the matrix[0][0] == 0 then all the indexes on that row will be marked  

Assign correct value to col0
* if the remaining ith indexes from 1 to n is marked with 0 then mark col0 as 0

If still confusing watch striver explanation!
##### Source Code

```
class Solution {
    public void setZeroes(int[][] matrix) {
        int i, j, col0=1;
        for(i=0;i<matrix.length;i++)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    if(j!=0)
                    {
                        matrix[0][j] = 0;
                    }
                    else
                    {
                        col0 = 0;
                    }
                }
            }
        }

        for(i=1;i<matrix.length;i++)
        {
            for(j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

       if(matrix[0][0]==0)
        {
            for(j=0;j<matrix[0].length;j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0)
        {
            for(i=0;i<matrix.length;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
```

CROSS check TC with Striver
``` 
 Time complexity :
 - O(2 * (m * n)) - where m is row_size and n is column_size

 Space Complexity :
 O(1) - since there were row (with size m) & col (with size n) array used 
```
_______
