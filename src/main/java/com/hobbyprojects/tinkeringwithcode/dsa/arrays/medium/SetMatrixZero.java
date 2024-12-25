package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import java.util.Scanner;

public class SetMatrixZero {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    //    System.out.print("Number of rows :- ");
    //    int m = sc.nextInt();
    //    System.out.print("Number of columns :- ");
    //    int n = sc.nextInt();
    //    int[][] arr = initialise2DArray(m, n);
    int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    display2DArray(arr);
    setZeroesBrute(arr);
    arr = new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    setZeroesBetter(arr);
    //    setZeroesOptimal(arr);
  }

  private static void display2DArray(int[][] arr) {
    int i, j;
    int m = arr.length;
    int n = arr[0].length;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        System.out.print(arr[i][j] + "\t");
      }
      System.out.println();
    }
  }

  private static int[][] initialise2DArray(int m, int n) {
    int[][] arr = new int[m][n];
    int i, j;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        System.out.print("Enter value :- ");
        arr[i][j] = sc.nextInt();
      }
    }
    return arr;
  }

  public static void setZeroesBetter(int[][] ar) {
    int i, j;
    int m = ar.length;
    int n = ar[0].length;

    int row[] = new int[m];
    int col[] = new int[n];

    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (ar[i][j] == 0) {
          // mark rows
          row[i] = 1;

          // mark columns
          col[j] = 1;
        }
      }
    }
    // For all those indexes which were supposed to be 0
    // let's mark it as 0 in the actual array
    System.out.println("\n Set Zeroes Better Output :- ");
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (row[i] == 1 || col[j] == 1) {
          ar[i][j] = 0;
        }
        System.out.print(ar[i][j] + ", ");
      }
      System.out.println();
    }
  }

  public static void setZeroesBrute(int[][] nums) {
    int i, j, m = nums.length, n = nums[0].length;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (nums[i][j] == 0) {
          markRows(nums, m, j);
          markColumns(nums, n, i);
        }
      }
      System.out.println();
    }
    System.out.println("Set Zeroes Brute Output :- ");
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (nums[i][j] == -1) {
          nums[i][j] = 0;
        }
        System.out.print(nums[i][j] + ", ");
      }
      System.out.println();
    }
  }

  static void markRows(int[][] nums, int m, int j) {
    for (int i = 0; i < m; i++) {
      if (nums[i][j] != 0) nums[i][j] = -1;
    }
  }

  static void markColumns(int[][] nums, int n, int i) {
    for (int j = 0; j < n; j++) {
      if (nums[i][j] != 0) nums[i][j] = -1;
    }
  }
}
