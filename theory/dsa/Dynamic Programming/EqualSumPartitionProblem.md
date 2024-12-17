[Solve the problem here](https://leetcode.com/problems/partition-equal-subset-sum/description/)

```java 
class Solution {
    public boolean canPartition(int[] nums) {
        // Find out the sum 
        // Early exit if ODD 
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        else
        {
            return isSubsetSumFound(nums, nums.length, sum/2);
        }
    }
    public Boolean isSubsetSumFound(int nums[], int n, int target) 
    {
        Boolean t[][] = new Boolean[n+1][target+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<target+1;j++)
            {
                if(i==0) { // if number is 0, then subset sum is not possible 
                    t[i][j] = false;
                }
                else if(j==0) { // if number is not 0, but the target is 0, then with empty subset, it is possible to have a target '0'
                    t[i][j] = true; 
                }
                else if(i>0 && nums[i-1]<=j){
                    t[i][j] = (t[i-1][j-nums[i-1]]) || (t[i-1][j]);
                }
                else if(i>0){
                    t[i][j] = t[i-1][j]; // Exclude the number and move ahead.
                }
            }
        }
        return t[n][target];
    }
           
}
```


---

## **Complexity Analysis**

| Metric             | Complexity         |
|--------------------|--------------------|
| **Time Complexity** | O(n \* target)     |
| **Space Complexity**| O(n \* target)     |

- **Time Complexity:** The DP table is of size `n x target`, and each cell is processed once.
- **Space Complexity:** The 2D DP table requires `O(n x target)` space.

---