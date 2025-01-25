package com.hobbyprojects.tinkeringwithcode.dsa.binaryTree;

import java.util.Scanner;

public class BinaryTreePractice {
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    private Node root;


    public void insert(Scanner sc) {
        System.out.println("Enter value for root node :- ");
        root = new Node(sc.nextInt());
        insert(sc, root);
    }

    private void insert(Scanner sc, Node node) {
        System.out.println("insert at left (y/n) :- ");
        String left = sc.next();
        if(left.equals("y")) {
            System.out.println("Enter value for left of NODE "+node.data+" :- ");
            node.left = new Node(sc.nextInt());
            insert(sc, node.left);
        }
        System.out.println("insert at right (y/n) :- ");
        String right = sc.next();
        if(right.equals("y")) {
            System.out.println("Enter value for right of NODE "+node.data+" :- ");
            node.right = new Node(sc.nextInt());
            insert(sc, node.right);
        }
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int level) {
        if(node == null)
            return;
        print(node.right, level + 1);
        for(int i =0;i<level;i++) {
            System.out.print("\t\t");
        }
        System.out.println(node.data);
        print(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreePractice btp = new BinaryTreePractice();
        btp.insert(sc);
        btp.print();
    }
}
