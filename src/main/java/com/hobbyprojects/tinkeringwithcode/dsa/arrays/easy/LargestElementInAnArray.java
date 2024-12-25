package com.hobbyprojects.tinkeringwithcode.dsa.arrays.easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Deprecated
public class LargestElementInAnArray {
  public static void main(String[] args) {
    int[] ar = {12, 24, 81, 9};
    //        log.info("Largest element via Selection Sort :-
    // {}".formatted(findLargestElementInAnArray("SELECTION_SORT", ar)));
  }

  //    private static int findLargestElementInAnArray(String choice, int[] ar) {
  //        return switch(choice){
  //            case "SELECTION_SORT":
  //                selectionSort();
  //                break;
  //            case "INSERTION_SORT":
  //                find
  //            default:
  //                throw new IllegalStateException("Unexpected value: " + choice);
  //        }
  //    }
  //
  //    private int[] selectionSort() {
  //
  //        return;
  //    }
  //
  //    private int[] insertionSort(int[] ar) {
  //        /*
  //         * 1. Pick the element from the right
  //         * 2. Keep swapping it to the left till it happens
  //         * */
  //        int n = ar.length;
  //        for (int i = 0; i < n; i++) {
  //            int j = i;
  //            while (j = 0 && ar[j - 1] > ar[j]) {
  //                int temp = ar[j - 1];
  //                ar[j - 1] = ar[j];
  //                ar[j] = temp;
  //                j--;
  //            }
  //        }
  //        return;
  //    }
}
