package com.hobbyprojects.tinkeringwithcode.dsa.bitmanipulation;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class BitManipulation {
    public static void main(String[] args) {
        System.out.println("Enter the input :-");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String numberToBase2InString = convertToBase2(n);
        int numberToBase2 = Integer.parseInt(numberToBase2InString);
        System.out.println("Convert to base 2 :- " + numberToBase2);
        System.out.println("Convert to base 10 :- " + convertToBase10(numberToBase2));
    }

    static double convertToBase10(int n) {
        String str = Integer.toString(n);
        int sum = 0, p2 = 1;
        int length = str.length() - 1;
        for (int i = length; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                sum = sum + p2;
            }
            p2 = p2 * 2;
        }
        return sum;
    }

    static String convertToBase2(int n) {
        int remainder;
        String s = "";
        while (n != 0) {
            remainder = n % 2;
            s = remainder + s;
            n = n / 2;
        }
        return s;
    }
}
