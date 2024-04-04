package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

import java.util.Scanner;

/**
 *
 *
 * <h3>Recursion</h3>
 *
 * identify the base condition first and then write the logic.
 */
public class PrintFromGivenNumberTillZero {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter value of n :-");
    int n = sc.nextInt();
    printFromGivenNumberTillZero(n);
  }

  static void printFromGivenNumberTillZero(int n) {
    System.out.println(n);
    n = n - 1;
    if (n < 0) {
      return;
    }
    printFromGivenNumberTillZero(n);
  }
}
