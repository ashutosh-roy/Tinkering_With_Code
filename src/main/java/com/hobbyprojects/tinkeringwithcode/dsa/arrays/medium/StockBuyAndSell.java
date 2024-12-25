package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

/**
 *
 *
 * <h3>Time Complexity :</h3>
 *
 * O(n) <br>
 * <br>
 *
 * <h3>Space Complexity :</h3>
 *
 * O(1)
 */
public class StockBuyAndSell {
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxPro = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      maxPro = Math.max(maxPro, prices[i] - minPrice);
    }
    return maxPro;
  }
}
