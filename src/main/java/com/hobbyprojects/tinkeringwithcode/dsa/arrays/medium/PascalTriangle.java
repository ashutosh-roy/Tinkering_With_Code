package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h2>Brute Force Approach :</h2>
 * <p>We'll use combination formula {@code nCr} to solve this. Let's break down the problem into 3 parts.
 * <ul>
 *     <li>Step 1. Get each element in Pascal's triangle using {@code nCr} where {@code n} is the rowth index and {@code r} is the columnth index.
 *     <br>For e.g., For row = 5 col = 3, the element is 6 (from {@code 5C3}) <br></li>
 *     <li>Step 2. Let's calculate all the elements of a Pascal's triangle for a given row.</li>
 *     <li>Step 3. Combine all those row wise Pascal's triangle elements into a {@code List<List<Integer>>}.</li>
 * <br>
 * <h3>Time complexity : </h3><p>{@code O(n) + O(n-r) + O(r)}</p>
 * </ul></p>
 * <br><br>
 * <h2>Optimal Force Approach :</h2>
 * <ul>
 *     <li>For e.g., 5C3 is {@code 5! / (3! X 2!)} where {@code (5X4) X 3! / (3! X (2X1))} <br> So 3! is repeated in numerator and denominator</li>
 *     <li>To avoid the repeated 3! in above e.g., we can do this
 *     {@code for(i=1;i<col;i++)
 *     {
 *         result = result * (row - i)/i;
 *         which for 5C3, result = (5/1) * (4/2) = 10
 *     }}</li>
 * </ul></p>
 * <br>
 * <h3>Time complexity : </h3> <p>{@code  O(n*r*r) ~ O(n3), where n = number of rows, and r = column index.}</p>
 * <br>
 * <h3>Space complexity : </h3> <p>In this case, we are only using space to store the answer. That is why space complexity can be still considered as {@code O(1)}</p>
 * <br>
 * <h3> References:</h3>
 * <a href = "https://www.youtube.com/watch?v=bR7mQgwQ_o8&t=1210s">Video explanation</a><br>
 * <a href = "https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/#brute-force-approach">Reference Code</a>
 */


public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose which option to implement: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter row th index :-");
                int row = sc.nextInt();
                System.out.print("Enter column th index :-");
                int col = sc.nextInt();
                System.out.printf("\nFinal Result :- %d ", getElementBasedOn(row, col));
                break;

            case 2:
                System.out.println("\nEnter the row for which you want to receive the Pascal's elements :- \n");
                int n = sc.nextInt();
                getRowBasedOn(n);
                break;

            case 3:
                System.out.println("\nEnter the number of rows required in Pascal's Triangle :- \n");
                int numberOfRows = sc.nextInt();
                getPascalTriangleBasedOn(numberOfRows);
                break;
        }
    }

    /**
     * <h2>Variation 1</h2>
     * Use nCr formula to calculate the element
     *
     * @param row       row's index
     * @param nthColumn column's index
     * @return the element present in Pascal's Triangle
     */
    public static int getElementBasedOn(int row, int nthColumn) {
        int res = 1;
        for (int col = 1; col < nthColumn; col++) {
            res = res * (row - col) / col;
        }
        System.out.printf("Elements based on %dth row and %dth column :- %d \n", row, nthColumn, res);
        return res;
    }

    /**
     * <h2>Variation 2</h2>
     * Returns nth row of Pascal's Triangle
     *
     * @param nthRow row's number
     * @return List<Integer>
     */
    public static List<Integer> getRowBasedOn(int nthRow) {
        List<Integer> result = new ArrayList<>();
        System.out.println("\n\nElements for nth row :- ");
        for (int col = 1; col <= nthRow; col++) {
            result.add(getElementBasedOn(nthRow, col));

        }
        for (int i : result) {
            System.out.printf("%d, ", i);
        }
        return result;
    }

    /**
     * <h2>Variation 3</h2>
     *
     * @param numberOfRows number of rows for which Pascal's Triangle is to be generated
     * @return List<List < Integer>>
     */
    public static List<List<Integer>> getPascalTriangleBasedOn(int numberOfRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 1; row <= numberOfRows; row++) {
            result.add(getRowBasedOn(row));
        }
        System.out.println("\n\nPascal's Triangle :-");
        result.forEach(System.out::println);
        return result;
    }
}
