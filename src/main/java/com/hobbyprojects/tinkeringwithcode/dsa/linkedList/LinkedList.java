package com.hobbyprojects.tinkeringwithcode.dsa.linkedList;

public class LinkedList {
  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static LinkedList insert(LinkedList list, int data) {
    Node new_node = new Node(data);
    if (list.head == null) {
      list.head = new_node;
    } else {
      Node current_node = list.head;
      while (current_node.next != null) {
        current_node = current_node.next;
      }
      current_node.next = new_node;
    }
    return list;
  }

  public static void print(LinkedList list) {
    Node current_node = list.head;
    System.out.println("Linked List : ");
    while (current_node != null) {
      System.out.print(current_node.data + " -> ");
      current_node = current_node.next;
    }
    System.out.println("null");
  }

  public static LinkedList deleteByKey(LinkedList list, int key) {
    Node current_node = list.head;
    Node previous_node = null;
    if (current_node.next != null && current_node.data == key) {
      list.head = current_node.next;
      System.out.println("Key " + key + " deleted from linkedList");
    } else {
      while (current_node != null && current_node.data != key) {
        previous_node = current_node;
        current_node = current_node.next;
      }
      if (current_node != null) {
        previous_node.next = current_node.next;
        System.out.println("Key " + key + " deleted from linkedList");
      } else {
        System.out.println("Key to be deleted from linkedList not found!");
      }
    }
    return list;
  }

  //    public static void deleteByPosition(LinkedList list, int position) {
  //        int current_position = 0;
  //        if(list.head == null) {
  //
  //        } else {
  //            while(list == && ) {
  //
  //            }
  //        }
  //    }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list = insert(list, 123);
    list = insert(list, 124);
    list = insert(list, 125);
    print(list);
    list = deleteByKey(list, 120);
    print(list);
    list = deleteByKey(list, 123);
    print(list);
    list = deleteByKey(list, 125);
    print(list);
  }
}
