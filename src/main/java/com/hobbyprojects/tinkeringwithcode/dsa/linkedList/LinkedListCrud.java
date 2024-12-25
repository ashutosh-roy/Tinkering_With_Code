package com.hobbyprojects.tinkeringwithcode.dsa.linkedList;

public class LinkedListCrud {
  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static LinkedListCrud insert(LinkedListCrud list, int data) {
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

  public static LinkedListCrud deleteByKey(LinkedListCrud list, int data) {
    // Case 1 : If head node has the key, unlink the head node from the existing key and point to
    // the next key !
    Node current_node = list.head;
    Node previous_node = null;
    if (current_node != null && current_node.data == data) {
      list.head = current_node.next;
      System.out.println("Key " + data + " is deleted.");
    } else {
      // Case 2 : If the key is somewhere in the middle, then make the previous node point to the
      // node next to current node
      while (current_node != null && current_node.data != data) {
        previous_node = current_node;
        current_node = current_node.next;
      }
      if (current_node != null) {
        previous_node.next = current_node.next;
        System.out.println("Key " + data + " is deleted.");
      } else {
        System.out.println("Key to be deleted " + data + " is not found");
      }
    }
    return list;
  }

  public static LinkedListCrud deleteByPosition(LinkedListCrud list, int position) {
    Node current_node = list.head;
    Node previous_node = null;
    int current_position = 0;
    boolean isDeleted = false;
    // Case 1 : Delete the HEAD node
    if (current_position == position) {
      list.head = null;
      System.out.println("Data " + current_node.data + " deleted at " + position + ".");
    }
    // Case 2 : Delete the HEAD node from any index!
    else {
      while (current_node != null) {
        previous_node = current_node;
        current_node = current_node.next;
        current_position++;
        if (current_position == position) {
          previous_node.next = current_node.next;
          isDeleted = true;
          System.out.println("Data " + previous_node.data + " deleted at " + position + ".");
        }
      }
    }
    if (!isDeleted) {
      System.out.println("Position not found " + position + " for key to be deleted.");
    }
    return list;
  }

  public static void print(LinkedListCrud list) {
    Node current_node = list.head;
    while (current_node != null) {
      System.out.print(current_node.data + ", ");
      current_node = current_node.next;
    }
  }

  public static void main(String[] args) {
    LinkedListCrud list = new LinkedListCrud();
    list = insert(list, 123);
    print(list);
    list = insert(list, 124);
    print(list);
    // TODO : Delete By Key
    list = deleteByKey(list, 121);
    print(list);
    list = deleteByKey(list, 122);
    print(list);
    list = deleteByKey(list, 123);
    print(list);
    list = deleteByKey(list, 124);
    print(list);
    // TODO : Delete By Position
    // TODO : Reverse LinkedList
    // TODO : Find middle of linkedlist
    // TODO : Merge two sorted LinkedList ( BRUTE FORCE : dumbest approach try maadi !)
    print(list);
    list = deleteByPosition(list, 2);
    print(list);
    list = insert(list, 123);
    print(list);
    list = insert(list, 124);
    print(list);
    list = deleteByPosition(list, 2);
    print(list);
  }
}
