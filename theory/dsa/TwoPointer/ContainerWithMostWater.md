### Container with most water

[Solve here](https://leetcode.com/problems/container-with-most-water/description/)

```java

class Solution {
    public int maxArea(int[] height) {
        // No Input Edgecase        
        int start = 0, end = height.length - 1;
        int area = Integer.MIN_VALUE, max;
        while(start<=end)
        {
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));
            if(height[start] < height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return area;
    }
}
```