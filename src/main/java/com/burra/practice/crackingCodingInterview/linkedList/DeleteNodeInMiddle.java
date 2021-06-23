package com.burra.practice.crackingCodingInterview.linkedList;

public class DeleteNodeInMiddle {
    public boolean deleteMiddleNode(LinkedListNode middleNode) {
        if(middleNode == null || middleNode.next == null) return false;
        LinkedListNode next = middleNode.next;
        middleNode.data = next.data;
        middleNode.next = next.next;
        return true;
    }
}
