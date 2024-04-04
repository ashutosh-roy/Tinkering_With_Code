package com.hobbyprojects.tinkeringwithcode.dsa;

import java.util.Scanner;

public class SetMatrixZero {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Number of rows :- ");
    int m = sc.nextInt();
    System.out.print("Number of columns :- ");
    int n = sc.nextInt();
    int[][] arr = initialise2DArray(m, n);
    display2DArray(arr);
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

  //    public void setZeroes(int[][] matrix) {
  //
  //        for()
  //        {
  //
  //        }
  //    }
}
