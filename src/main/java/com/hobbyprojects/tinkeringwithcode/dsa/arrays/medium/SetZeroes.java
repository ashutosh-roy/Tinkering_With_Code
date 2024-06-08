package com.hobbyprojects.tinkeringwithcode.dsa.arrays.medium;

class SetZeroes {
    public static void main(String[] args) {
        int[][] ar = {{0, 1, 2, 0}, {1, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(ar);
    }

    public static void setZeroesOptimised(int[][] nums) {

    }

    public static void setZeroes(int[][] nums) {
        int i, j, m = nums.length, n = nums[0].length;
        System.out.println("Row size - " + m);
        System.out.println("Column size - " + n);
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (nums[i][j] == 0) {
                    markRows(nums, m, i);
                    markColumns(nums, n, j);
                    System.out.println(nums[i][j] + ", ");
                }
            }
            System.out.println(nums[i][j]);
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (nums[i][j] == -1) {
                    nums[i][j] = 0;
                }
            }
        }
    }

    static void markRows(int[][] nums, int m, int j) {
        for (int i = 0; i < m; i++) {
            nums[i][j] = -1;
        }
    }

    static void markColumns(int[][] nums, int n, int i) {
        for (int j = 0; j < n; j++) {
            nums[i][j] = -1;
        }
    }
}