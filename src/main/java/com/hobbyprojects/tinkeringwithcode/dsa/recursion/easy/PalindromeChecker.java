package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

import java.util.Scanner;

/**
 *
 *
 * <h3>Recursion</h3>
 *
 * identify the base condition first and then write the logic.
 */
public class PalindromeChecker {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter value of string :-");
    String str = sc.next();
    String reversedString = makeReverse(str.length(), str);
    System.out.printf("Comparing OG String : %s and Reversed String : %s%n", str, reversedString);
    if (str.trim().equals(reversedString.trim())) {
      System.out.println("It's a palindrome !");
    } else {
      System.out.println("It's not a palindrome !");
    }
  }

  public static String makeReverse(int index, String str) {
    if (index == 0) {
      return "";
    }
    --index;
    return str.charAt(index) + makeReverse(index, str);
  }
}
