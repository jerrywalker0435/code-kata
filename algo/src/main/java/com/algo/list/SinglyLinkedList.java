package com.algo.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyu201
 * @date 2021/6/10
 */
public class SinglyLinkedList {

    private Node head = null;


    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToTail(int value) {
        Node newNode = new Node(value,null);
        insertToTail(newNode);
    }

    private void insertToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = newNode;
        }
    }

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}