package com.hobbyprojects.tinkeringwithcode.dsa.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackCrud implements Crud {
  Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StackCrud ob = new StackCrud();
    System.out.println("Enter value of n :-");
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      System.out.println("Enter element :-");
      int element = sc.nextInt();
      ob.push(element);
    }
    ob.printContents();
    ob.pop();
    ob.printContents();
    ob.pop(144);
    ob.printContents();
    System.out.println("Enter index to pop :-");
    int index = sc.nextInt();
    ob.popGivenIndex(index);
    ob.printContents();
  }

  @Override
  public void push(int element) {
    stack.push(element);
  }

  @Override
  public void pop() {
    System.out.println("Pop element(LIFO) :- ");
    stack.pop();
  }

  @Override
  public void pop(int element) {
    System.out.println("Pop a specific element :- ");
    stack.removeElement(element);
  }

  @Override
  public void popGivenIndex(int index) {
    if (index < stack.size()) {
      System.out.println("Pop an element at index :- " + index);
      stack.removeElementAt(index);
    }
  }

  @Override
  public void printContents() {
    System.out.println("Contents of Stack :- ");
    for (Integer i : stack) {
      System.out.println(i);
    }
  }
}
