package com.burra.practice;

import java.io.IOException;
import java.util.Scanner;

public class ReverseDoublyLinkedList {

  private static final Scanner scanner = new Scanner(System.in);

  public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.println(node.data);

      node = node.next;

      if (node != null) {
        System.out.println(sep);
      }
    }
  }

  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode prev = null;

    while (head != null) {
      DoublyLinkedListNode next = head.next;
      head.next = prev;
      head.prev = next;
      prev = head;
      head = next;
    }
    return prev;
  }

  // Complete the reverse function below.

  public static void main(String[] args) throws IOException {

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      DoublyLinkedList llist = new DoublyLinkedList();

      int llistCount = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < llistCount; i++) {
        int llistItem = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        llist.insertNode(llistItem);
      }

      DoublyLinkedListNode llist1 = reverse(llist.head);

      printDoublyLinkedList(llist1, " ");
    }

    scanner.close();
  }

  static class DoublyLinkedListNode {

    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {

    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
        node.prev = this.tail;
      }

      this.tail = node;
    }
  }
}

