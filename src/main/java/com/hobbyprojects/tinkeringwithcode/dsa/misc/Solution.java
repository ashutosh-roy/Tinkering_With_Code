package com.hobbyprojects.tinkeringwithcode.dsa.misc;

/*Given an array of integers and a target value, find the smallest contiguous subarray whose sum is greater than or equal to the target

input - nums = [2, 3, 1, 2, 4, 3], target = 7 output - [4, 3]
input - nums = [1, 1, 1, 1, 1, 1, 1, 1], target = 11 output - []
input - nums = [5, 1, 3, 5, 10, 7, 4, 9, 2], target = 15 output - [10, 5]
*/
class Solution {
    public static int[] findShortestSubarray(int arr[], int target) {
        if(arr.length==1)
        {
            if(arr[0]!= target){
                return new int[0];
            }
            else {
                return arr;
            }
        }
        int start =0, end = 1;
        int sum = arr[start];
        int result[] = new int[arr.length];
        while(start<=end) {
            sum = sum + arr[end];
            if(sum<target) {
                end++;
            }
            else if(sum == target) {
                break;
            }
            else {
                start = end -1;
                sum = arr[start];
            }
        }
        int k =0;
        for(int i=start;i<end;i++){
            result[k++] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int ar[] = {2, 3, 1, 2, 4, 3};
        System.out.println();
        int[] shortestSubarray = Solution.findShortestSubarray(ar, 7);
        for(int i=0;i<shortestSubarray.length;i++){
            System.out.println(shortestSubarray[i]);
        }
    }
}