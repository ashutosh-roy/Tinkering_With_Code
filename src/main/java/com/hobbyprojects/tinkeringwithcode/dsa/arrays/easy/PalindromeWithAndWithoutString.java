package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

class PalindromeWithAndWithoutString {
  // 1st Approach
  public boolean isPalindrome(int x) {
    String str = Integer.toString(x), s = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      s = s + str.charAt(i);
    }
    return s.equals(str);
  }

  // 2nd Approach
  public boolean isPalindromee(int x) {
    if (x < 0) {
      return false;
    }
    int revertedNumber = 0;
    int xCopy = x;
    while (x > 0) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x = x / 10;
    }
    System.out.println(revertedNumber);
    if (xCopy == revertedNumber) return true;
    else return false;
  }
}
