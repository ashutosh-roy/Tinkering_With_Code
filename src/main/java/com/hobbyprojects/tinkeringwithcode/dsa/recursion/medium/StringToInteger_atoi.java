package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.Scanner;

public class StringToInteger_atoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n :-");
        String s = sc.next();
        System.out.println("ATOI = " + myAtoi(s));
    }

    public static int myAtoi(String s) {
        int result;
        String str = "";
        boolean isNegative = false, skip = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                isNegative = true;
            }
            if ((ch == ' ') || (ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
                skip = true;
            }
            if (!skip) {
                if (ch >= 48 && ch <= 57) {
                    str = (ch != 48) ? str + ch : str;
                }
            }
            skip = false;
        }
        result = Integer.parseInt(str);
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return isNegative ? -result : result;
    }
}
