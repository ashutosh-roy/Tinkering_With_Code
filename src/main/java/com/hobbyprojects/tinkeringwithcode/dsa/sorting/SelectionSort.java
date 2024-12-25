package com.hobbyprojects.tinkeringwithcode.dsa.sorting;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectionSort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    log.info("Enter size of array :-");
    int n = sc.nextInt();
    int[] ar = new int[n];
    log.info("Enter elements in the array :-");
    for (int i = 0; i < ar.length; i++) {
      ar[i] = sc.nextInt();
    }
    selectionSort(ar);
  }

  public static void selectionSort(int[] ar) {
    int min = 0;
    for (int i = 0; i < ar.length - 1; i++) {
      min = i;
      for (int j = i + 1; j < ar.length; j++) {
        if (ar[j] < ar[min]) {
          min = j;
        }
      }
      int temp = ar[i];
      ar[i] = ar[min];
      ar[min] = temp;
    }
    log.info("After selection sort \n [");
    for (int i = 0; i < ar.length; i++) {
      log.info(ar[i] + ",");
    }
    log.info("]");
  }
}
