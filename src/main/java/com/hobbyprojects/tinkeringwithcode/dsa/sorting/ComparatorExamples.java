package com.hobbyprojects.tinkeringwithcode.dsa.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class ComparatorExamples {


    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[ %s, %s ]".formatted(x, y);
        }

        @Override
        public int compareTo(Pair o) {
            int cmp = this.x - o.x;
            return cmp == 0 ? this.y - o.y : cmp;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        Pair[] p = new Pair[10];
        for (int i = 0; i < 10; ++i) {
            p[i] = new Pair(random.nextInt(100), random.nextInt(200));
        }

        print(p);

        Arrays.sort(p);

        print(p);


    }

    private static void sort1CustomArray(Pair[] p) {
        Arrays.sort(p, (f, s) -> {
            int cmp = f.x - s.x;
            return cmp == 0 ? f.y - s.y : cmp;

        });
    }

    private static void sortIntegersArray() {
        int[][] matrix =
                new int[][]{{0, 30}, {5, 10}, {15, 20}, {7, 20}, {2, 4}, {1, 2}, {1, 5}, {1, 10}};

        sort1(matrix);

        print(matrix);
    }

    private static void sort3(int[][] matrix) {
        Arrays.sort(matrix, new ArrayComparator());
    }

    private static void sort2(int[][] matrix) {
        Arrays.sort(matrix, Comparator.comparing((int[] x) -> x[0]).thenComparingInt(x -> x[1]));
    }

    private static void sort1(int[][] matrix) {
        Arrays.sort(
                matrix,
                (firstRow, secondRow) -> {
                    if (firstRow[0] != secondRow[0]) {
                        return firstRow[0] - secondRow[0];
                    } else {
                        return firstRow[1] - secondRow[1];
                    }
                });
    }


    static class ArrayComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] firstRow, int[] secondRow) {
            if (firstRow[0] != secondRow[0]) {
                return firstRow[0] - secondRow[0];
            } else {
                return firstRow[1] - secondRow[1];
            }
        }
    }


    static void print(int[]... a) {

        for (int[] x : a) {
            System.out.println(Arrays.toString(x));
        }
    }

    static void print(Object[]... a) {

        for (Object[] x : a) {
            System.out.println(Arrays.toString(x));
        }
    }
}