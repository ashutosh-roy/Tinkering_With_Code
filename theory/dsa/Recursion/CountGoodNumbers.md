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

* What are the sub-problems here?

* We have only two possibilities : either even (5^(n/2)) or odd possibilities (4^(n/2)).

* We calculate even possibilities first and then the odd possibilities

* Remember To : Always do a MOD of the products (at every step) to reduce the large number of digits

```
n = 5. 
We calculate 
even_power : 3
odd_power : 2
- even_possibility : pow (5, even_power)
- odd_possibility  : pow (4, odd_power)

pow(value, power)
Base case : if(n==0) return 1;
Recursive case : int temp = pow(value, power/2)

```

``` 
  static int mod = (int) 1e9 + 7;
  public static long raiseTo(long value, long power) {
      long temp;
      // Using Divide and Conquer
      if (power == 0) return 1;
      temp = raiseTo(value, power / 2);
      if (power % 2 == 0) return (temp * temp) % mod;
      else return (value * temp * temp) % mod;
  }

  public static int countGoodNumbers(long n) {
      long power_even = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
      long power_odd = n / 2;
      long even_possibility = raiseTo(5, power_even) % mod;
      long odd_possibility = raiseTo(4, power_odd) % mod;
      long ans = odd_possibility != 0 ? (even_possibility * odd_possibility) % mod : even_possibility;
      return (int) ans;
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


