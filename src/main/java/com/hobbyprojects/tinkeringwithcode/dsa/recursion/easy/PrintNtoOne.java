package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

public class PrintNtoOne {

    static void printNToOne(int n) {
        if(n==0)
        {
            return;
        }
        System.out.println(n);
        printNToOne(n-1);
    }
    // TODO : This means Backtracking
    static void printOneToN(int n) {
        if(n==0)
        {
            return;
        }
        printOneToN(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        System.out.println("---N To 1---");
        printNToOne(4);
        System.out.println("---1 To N---");
        printOneToN(4);
    }
}
