package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

class NextPermutation {
  public static void nextPermutation(int[] nums) {
    int i, ind = -1, n = nums.length;
    // For e.g., 1, 3, 2
    // Step 1 : Find the break point after which all the elements are in increasing order
    for (i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        ind = i;
        break;
      }
    }

    // If no breakpoint found then
    if (ind == -1) {
      reverseArray(nums, 0, n - 1);
    } else {
      // For e.g., 1, 3, 2 -> 2, 3, 1
      // Step 2 : Swap the index with the next element
      for (i = n - 1; i > ind; i--) {
        if (nums[i] > nums[ind]) {
          int temp = nums[i];
          nums[i] = nums[ind];
          nums[ind] = temp;
          break;
        }
      }
      // For e.g., 2, 3, 1 -> 2, 1, 3
      // Step 3 : Reverse the right part of the array
      reverseArray(nums, ind + 1, n - 1);
    }
  }

  static void reverseArray(int[] nums, int firstIndex, int lastIndex) {
    int temp = 0;
    while (firstIndex < lastIndex) {
      temp = nums[firstIndex];
      nums[firstIndex] = nums[lastIndex];
      nums[lastIndex] = temp;
      firstIndex++;
      lastIndex--;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3};
    nextPermutation(nums);
    for (int i : nums) {
      System.out.println(i);
    }
  }
}
