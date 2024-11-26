package com.hobbyprojects.tinkeringwithcode.dsa.recursion.easy;

public class StringReversal {

    public static void main(String[] args) {
        String input = "TRY";
        StringBuilder output = new StringBuilder();
        int index = input.length() - 1;
        reverseString(input, output, index);
        System.out.println("Reversed String : "+reverseString(input, index));
    }

    // Non Parameterized
    static void reverseString(String input, StringBuilder output, int index)
    {
        if(index<0)
        {
            System.out.println(output);
            return;
        }
        output.append(input.charAt(index));
        index--;
        reverseString(input, output, index);
    }

    // Parameterized
    static String reverseString(String input, int index)
    {
        if(index<0)
            return "";

        return input.charAt(index) + reverseString(input, index-1);
    }

}
