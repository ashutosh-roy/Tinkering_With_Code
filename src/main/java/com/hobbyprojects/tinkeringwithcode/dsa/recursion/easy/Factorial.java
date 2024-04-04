package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

import java.util.Scanner;

/**
 *
 *
 * <h3>Recursion</h3>
 *
 * identify the base condition first and then write the logic.
 */
public class Factorial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter value of n :-");
    int n = sc.nextInt();
    System.out.printf("Factorial of %s :- %s", n, calculateFactorial(n));
  }

  private static int calculateFactorial(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 1) {
      return 1;
    }
    return n * calculateFactorial(n - 1);
  }
}
