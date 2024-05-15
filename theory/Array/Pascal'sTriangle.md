### Brute Force Approach :

We'll use combination formula ``` nCr``` to solve this. Let's break down the problem into 3 parts.
Step 1. Get each element in Pascal's triangle using ``` nCr} where  n is the rowth index
and r is the columnth index.```
For e.g., For row = 5 col = 3, the element is 6 (from ``` 5C3}```)
Step 2. Let's calculate all the elements of a Pascal's triangle for a given row.
Step 3. Combine all those row wise Pascal's triangle elements into a ``` List<List<Integer>>```

##### Time complexity :

``` O(n) + O(n-r) + O(r)```

### Optimal Force Approach :

For e.g., 5C3 is  ```5! / (3! X 2!)```
where ``` (5X4) X 3! / (3! X (2X1))}``` So 3! is repeated in numerator and denominator.

To avoid the repeated 3! in above e.g., we can do this :-

``` 
for(i=1;il;i++)
{
    result = result * (row - i)/i;
    which for 5C3, result = (5/1) * (4/2) = 10
} 
```

##### Time complexity :

``` O(n*r*r) ~ O(n3), where n = number of rows, and r = column index.```

##### Space complexity :

```In this case, we are only using space to store the answer. That is why space complexity can be still considered as  O(1)```

### References:

[Video explanation](https://www.youtube.com/watch?v=bR7mQgwQ_o8&t=1210s)

[Reference Code](https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/#brute-force-approach)
