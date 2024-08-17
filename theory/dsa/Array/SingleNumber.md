## Template for DSA notes

### Brute Force Approach :

Initialise a map where count of all the digits are stored and get the digit whose count is 1

##### Time complexity :

``` O() ```

### Optimal Approach :

Using XOR operator : similar digits or numbers get cancelled out
For e.g., 4^4^3^3^1 => 1

``` 
    public static int findSingleNumberUsingXOR(int[] ar) {
        int singleNumber = 0;
        for (int i : ar) {
            singleNumber = singleNumber ^ i;
        }
        return singleNumber;
    }
```

##### Time complexity :

``` O(n) ```

##### Space complexity :

``` O```

### References:

[Video Reference](https://www.youtube.com/watch?v=sFBCAl8yBfE)

[Article reference]()
