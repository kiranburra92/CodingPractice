package com.burra.practice.educative;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithArbitraryPointer {
    public class Node {
        int val;
        Node next;
        Node arbitraryNode;

        Node(int x) {
            val = x;
        }
    }

    public Node DeepClone(Node head) {
        if(head == null)
            return null;
        Node current = head;
        Node current_head = null;
        Node previous_node = null;
        Map<Node, Node> map = new HashMap<>();
        while (current != null) {
            Node n = new Node(current.val);
            n.arbitraryNode = current.arbitraryNode;
            map.put(current, n);

            if(previous_node != null) {
                previous_node.next = n;
            }
            else {
                current_head = n;
            }
            previous_node = n;
            current = current.next;
        }

        Node actual_head = current_head;
        while (actual_head != null) {
            if(actual_head.arbitraryNode != null)
                actual_head.arbitraryNode = map.get(actual_head.arbitraryNode);

            actual_head = actual_head.next;
        }

        return current_head;
    }
}
