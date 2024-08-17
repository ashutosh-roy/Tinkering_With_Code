package com.hobbyprojects.tinkeringwithcode.dsa.recursion.medium;

import java.util.*;

public class PermutationOfString {
    public static void main(String[] args) {
        String input = "aab";
        List<String> result = new ArrayList<>();
        findPermutations(input, 0, result);
        System.out.println("With Duplicates");
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
        result = new ArrayList<>();
        System.out.println("Without Duplicates");
        findPermutationsWithoutDuplicates(input, 0, result);
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
    }

    static void findPermutations(String str, int start, List<String> result) {
        if(start == str.length())
        {
            result.add(str);
            return ;
        }
        for(int i=start;i<str.length();i++)
        {
            str = swap(str, start, i);
            findPermutations(str, start+1, result);
            str = swap(str, start, i);
        }
    }

    static String swap(String str, int start, int i) {
        char[] ch = str.toCharArray();

        char temp = ch[start];
        ch[start] = ch[i];
        ch[i] = temp;

        return String.valueOf(ch);
    }
    static void findPermutationsWithoutDuplicates(String str, int start, List<String> result) {
        if(start == str.length())
        {
            if(!result.contains(str)) {
                result.add(str);
            }
            return;
        }
        for(int i = start; i < str.length(); i++)
        {
            str = swap(str, start, i);
            findPermutationsWithoutDuplicates(str, start+1, result);
            str = swap(str, start, i);
        }
    }
}

