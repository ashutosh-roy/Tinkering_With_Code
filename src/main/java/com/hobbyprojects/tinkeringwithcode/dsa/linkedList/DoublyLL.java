package com.hobbyprojects.tinkeringwithcode.dsa.linkedList;

public class DoublyLL {
    Node head;
    static class Node {
      int data;
      Node prev;
      Node next;
      Node(int data) {
          this.data = data;
          Node prev = null;
          Node next = null;
      }
    }
    static void print(DoublyLL list) {
        Node current = list.head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static void convertToDLL(int[] arr, DoublyLL list) {
        list.head = new Node(arr[0]);
        Node current = list.head;
        for(int i = 1; i<=arr.length-1;i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

    static void insertBegin(DoublyLL list, int data) {
        Node new_node = new Node(data);
        if(list.head == null) {
            list.head = new_node;
        } else {
            new_node.next = list.head;
            list.head.prev = new_node;
            /*
             * in addition to updating the references, we also need to update
             */
            list.head = new_node;
        }
    }

    static void insertEnd(DoublyLL list, int data) {
        Node new_node = new Node(data);
        if(list.head==null) {
            list.head = new_node;
        }
        else {
            Node current = list.head;
            while(current.next!=null) {
                current = current.next;
            }
            current.next = new_node;
            new_node.prev = current;
        }
    }

    static void deleteBegin(DoublyLL list) {
        Node current = list.head;
        if(current!=null) {
            list.head = current.next;
            current.prev = null;
        } else {
            System.out.println("No delete operation can be performed.");
        }
    }

    static void deleteEnd(DoublyLL list) {
        Node current = list.head;
        while(current.next!=null) {
            current = current.next;
        }
        current = current.prev;
        current.next = null;
    }

    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        convertToDLL(new int[]{1,2,3}, list);

        System.out.println("Insert From Start");
        insertBegin(list, 123);
        print(list);

        System.out.println("Insert From End");
        insertEnd(list, 1234);
        print(list);

        System.out.println("Delete From Start");
        deleteBegin(list);
        print(list);

        System.out.println("Delete From End");
        deleteEnd(list);
        print(list);
    }
}
