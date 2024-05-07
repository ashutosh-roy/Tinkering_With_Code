## 1s and 2s Compliment

### References:

[Video Reference](https://www.youtube.com/watch?v=qQd-ViW7bfk&list=PLgUwDviBIf0rnqh8QsJaHyIX7KUiaPUv7&index=1)

### Approach :

1) Convert a number into its binary version i.e., base 2 version
2) Write the binary in after replacing 1s with 0s and 0s with 1s

``` 
 

```

```
    static String convertToBase2(int n) {
        int remainder;
        String s = "";
        while (n != 0) {
            remainder = n % 2;
            s = remainder + s;
            n = n / 2;
        }
        return s;
    }
```

##### Time complexity :

``` O(length of string)```

##### Space complexity :

``` O(1) ```


