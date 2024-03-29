package com.hobbyprojects.tinkeringwithcode.dsa.sorting;

/**
 * <h2>Brute Force Approach :</h2>
 * <p>Find the minimum element .</p>
 * <ul>
 *     <li>Step 1. Get each element in Pascal's triangle using {@code nCr} where {@code n} is the rowth index and {@code r} is the columnth index.
 *     <br>For e.g., For row = 5 col = 3, the element is 6 (from {@code 5C3}) <br></li>
 *     <li>Step 2. Let's calculate all the elements of a Pascal's triangle for a given row.</li>
 *     <li>Step 3. Combine all those row wise Pascal's triangle elements into a {@code List<List<Integer>>}.</li>
 * <br>
 * <h3>Time complexity : </h3><p>{@code O(n) + O(n-r) + O(r)}</p>
 * <p>
 */
public class SelectionSort {
}
