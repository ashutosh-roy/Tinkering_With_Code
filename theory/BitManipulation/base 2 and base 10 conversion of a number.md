## Base 2 and base 10 conversion of a number

### References:

[Video Reference](https://www.youtube.com/watch?v=qQd-ViW7bfk&list=PLgUwDviBIf0rnqh8QsJaHyIX7KUiaPUv7&index=1)

### Optimal Approach :

``` 
    static double convertToBase10(int n) {
        String str = Integer.toString(n);
        int sum = 0, p2 = 1;
        int length = str.length() - 1;
        for (int i = length; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                sum = sum + p2;
            }
            p2 = p2 * 2;
        }
        return sum;
    }
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

