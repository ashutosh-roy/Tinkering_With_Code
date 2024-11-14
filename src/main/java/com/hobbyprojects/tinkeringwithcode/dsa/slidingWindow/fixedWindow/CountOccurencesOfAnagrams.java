package com.hobbyprojects.tinkeringwithcode.dsa.slidingWindow.fixedWindow;

public class CountOccurencesOfAnagrams {

    static int search(String pat, String txt) {
        // code here
        int[] arr = new int[26];
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            arr[ch - 'a']++;
        }
        int i = 0, j = 0;
        int ans = 0;
        while (j < txt.length()) {
            arr[txt.charAt(j) - 'a']--;
            if (j - i + 1 == pat.length()) {
                if (allZero(arr)) {
                    ans++;
                }
                arr[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return ans;
    }

    static boolean allZero(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("Count Occurrences of Anagrams = " + search("for", "forxxorfxdofr"));
    }
}

