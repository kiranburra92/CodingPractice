package com.burra.practice.educative;

import java.io.IOException;
import java.util.Scanner;

public class InsertNodeInDoublyLinkedList {

  // Complete the sortedInsert function below.

  private static final Scanner scanner = new Scanner(System.in);

  /*
   * For your reference:
   *
   * DoublyLinkedListNode {
   *     int data;
   *     DoublyLinkedListNode next;
   *     DoublyLinkedListNode prev;
   * }
   *
   */
  static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode node = new DoublyLinkedListNode(data);
    DoublyLinkedListNode ref = head;
    if (head == null) {
      head = node;
    } else if (head.data >= node.data) {
      node.next = head;
      head.prev = node;
      head = node;
    } else {
      while (ref.next != null && ref.next.data < node.data) {
        ref = ref.next;
      }
      node.next = ref.next;

      if (ref.next != null) {
        ref.next.prev = node;
      }
      node.prev = ref;
      ref.next = node;

    }
    return head;
  }

  public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
    while (node != null) {
      System.out.println(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        System.out.println(sep);
      }
    }
  }

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

      int data = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

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
