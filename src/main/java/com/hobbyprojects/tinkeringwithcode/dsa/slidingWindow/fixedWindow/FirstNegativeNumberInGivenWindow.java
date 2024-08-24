package com.hobbyprojects.tinkeringwithcode.dsa.slidingWindow.fixedWindow;

import lombok.extern.slf4j.Slf4j;

import java.util.*;


@Slf4j
public class FirstNegativeNumberInGivenWindow {

    public static void main(String[] args) {
        long[] ar = {-8, 2, 3, -6, 10};
        printFirstNegativeInteger(ar, 5, 2);
        printFirstNegativeIntegerBruteForce(ar, 5, 2);
    }

    public static void printFirstNegativeIntegerBruteForce(long[] ar, long n, long k) {
        int i = 0, j = 0, count = 0;
        long[] resultAsAnArray = new long[(int) (n - k + 1)];

        long max = Integer.MIN_VALUE;
        for (i = 0; i < ar.length; i++) {
            for (j = i; j < k + i; j++) {
                if (j > ar.length - 1) {
                    break;
                }
                if (ar[j] < 0) {
                    max = ar[j];
                    break;
                }
            }
            if (max == Integer.MIN_VALUE) {
                max = 0;
            }
            if (count > resultAsAnArray.length - 1) {
                break;
            }
            resultAsAnArray[count++] = max;
            max = Integer.MIN_VALUE;
        }
        System.out.println("\nUsing Brute Force :- ");
        for (i = 0; i < resultAsAnArray.length; i++) {
            System.out.print(resultAsAnArray[i] + ", ");
        }
    }

    public static void printFirstNegativeInteger(long[] ar, long n, long k) {
        int i = 0, j = 0;
        List<Long> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        while (j < ar.length) {
            if (ar[j] < 0) {
                deque.offerLast(j);
            }
            if (j - i + 1 == k) {
                if (!deque.isEmpty()) {
                    result.add(ar[deque.peekFirst()]);
                } else {
                    result.add(0L);
                }
                if (!deque.isEmpty() && deque.peekFirst() == i) {
                    deque.pollFirst();
                }
                i++;
            }
            j++;
        }
        System.out.println();
        toArray(result, "Using Optimised :-");
    }

    public static long[] toArray(Object result, String message) {
        long[] resultAsAnArray = new long[((List<?>) result).size()];
        System.out.println(message);
        for (int i = 0; i < ((List<?>) result).size(); i++) {
            resultAsAnArray[i] = (long) ((List<?>) result).get(i);
            System.out.print(resultAsAnArray[i] + ", ");
        }
        return resultAsAnArray;
    }
}