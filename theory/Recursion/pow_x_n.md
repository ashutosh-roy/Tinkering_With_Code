
## Count Good Numbers

### Brute Force Approach :

* Use Math.pow to calculate the even and odd possibilities and multiply them

``` 
 Time complexity :
 O(n) : For cases where n is 10^16, this brute force approach will give a Time Limit Exceeded (TLE).

 Space Complexity :
 O(1) - constant 
```

### Optimised Approach :

* Use recursion
* Always do a MOD of the products to reduce the large number of digits

``` 
public static double myPow(double x, int n) {

    // Base condition: If n is 0, x^0 is 1
    if (n == 0) {
        return 1;
    }

    // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
    long N = n;

    // If n is negative, take the reciprocal of x and make N positive
    if (N < 0) {
        N = -N;
        x = 1 / x;
    }

    // If N is even, recursively compute the square of x^(N/2)
    if (N % 2 == 0) {
        return myPow(x * x, (int) (N / 2));
    }

    // If N is odd, recursively compute x^(N-1) and multiply it by x
    else {
        return x * myPow(x, (int) (N - 1));
    }
}
```

``` 
 Time complexity :
- O(log n) - since we are using divide and conquer approach so everytime we are executing recursive function for (n/2) times


 Space Complexity :
- O(log n) - (due to the depth of the recursion stack)
```

### Reference

[Why is TC of Recursive Functions -> log n?](https://stackoverflow.com/questions/13467674/determining-complexity-for-recursive-functions-big-o-notation)

[Leetcode Explanation](https://leetcode.com/problems/count-good-numbers/solutions/1317451/java-step-by-step-clear-explanation-with-pictures-o-logn/)


