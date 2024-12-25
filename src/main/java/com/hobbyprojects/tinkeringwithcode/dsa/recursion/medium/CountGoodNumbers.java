package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.Scanner;

public class CountGoodNumbers {
  static int mod = (int) 1e9 + 7;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter value of n :- ");
    int n = sc.nextInt();
    System.out.println("Total Count Of Good Numbers :- " + countGoodNumbers(n));
  }

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
}
