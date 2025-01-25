package com.hobbyprojects.tinkeringwithcode.dsa.binaryTree;

import java.util.Scanner;

public class BinaryTree {

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
        System.out.println("Enter root node: ");
        int val = sc.nextInt();
        root = new Node(val);
        insert(sc, root);
    }
    private void insert(Scanner sc, Node node) {
        System.out.println("Insert into left of node : (y/n)"+ node.data);
        String left = sc.next();
        if(left.equals("y")) {
            System.out.println("Enter element to be inserted :- ");
            int input = sc.nextInt();
            node.left = new Node(input);
            insert(sc, node.left);
        }
        System.out.println("Insert into right of node : (y/n)"+ node.data);
        String right = sc.next();
        if(right.equals("y")) {
            System.out.println("Enter element to be inserted :- ");
            int input = sc.nextInt();
            node.right = new Node(input);
            insert(sc, node.right);
        }
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }
        prettyDisplay(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(node.data);
        prettyDisplay(node.left, level + 1);
    }

    public int size(Node node) {
        if(node==null)
            return 0;
        int left = size(node.left);
        int right = size(node.right);
        return left + right + 1;
    }

    public int sum(Node node) {
        if(node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int sum = leftSum + rightSum + node.data;
        return sum;
    }

    public int height(Node node) {
        return 0;
    }

    public int max(Node node) {
        return 0;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        tree.insert(sc);
        tree.prettyDisplay();
        System.out.println("Size = "+tree.size(tree.root));
        System.out.println("Sum = "+tree.sum(tree.root));
    }
}
