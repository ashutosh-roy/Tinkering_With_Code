package com.hobbyprojects.tinkeringwithcode.dsa.linkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    static class Node {
        int key;
        int data;
        Node prev;
        Node next;
        Node(int key, int data) {
            this.key = key;
            this.data = data;
        }
    }

    LRUCache(int capacity) {
        this.capacity = capacity;
        // Initialise the Doubly LinkedList here.
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.data;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            // Remove the OLD NODE
            remove(map.get(key));
        }
        else if(map.size()==capacity) {
            // if the cache is full remove the NODE before TAIL
            if (tail.prev != head) {
                remove(tail.prev);
            }
        }
        insert(new Node(key, value));
    }

    void insert(Node node) {
        System.out.println("Node to be inserted :- "+node.data);
        map.put(node.key, node);
        // Connect the new node with the first node after the head
        node.next = head.next;
        head.next.prev = node;

        // Update the head's next pointer to the new node
        head.next = node;

        // Link the new node back to the head
        node.prev = head;
    }

    void remove(Node node) {
        System.out.println("Node to be removed :- "+node.data);
        map.remove(node.key);

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    void print() {
        Node node = head;
        StringBuilder st = new StringBuilder();
        while(node.next!=null){
            st.append("[").append(node.key).append(", ").append(node.data).append("] -> ");
            node = node.next;
        }
        st.append("X");
        System.out.println(st);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.print();
        cache.put(1, 1);
        cache.print();
        cache.put(2, 2);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.get(2);
        cache.print();
    }
}