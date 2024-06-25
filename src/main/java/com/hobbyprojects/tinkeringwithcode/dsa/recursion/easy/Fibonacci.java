package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n :-");
        int n = sc.nextInt();
        System.out.println("Fibonacci:- " + findFibonacci(n));
        System.out.println("Fibonacci:- " + findFibonacciRecursive(n));
    }

    static int findFibonacci(int n) {
        int fibonacci = 0, count = 1, first = 0, second = 1;
        if (n == 1) {
            return 0;
        }
        while (count != n) {
            fibonacci = first + second;
            first = second;
            second = fibonacci;
            count++;
        }
        return fibonacci;
    }

    static int findFibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return findFibonacciRecursive(n - 1) + findFibonacciRecursive(n - 2);
    }
}