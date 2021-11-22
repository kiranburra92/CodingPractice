package com.burra.practice.crackingCodingInterview.stacksAndQueues;

import java.util.Stack;

public class QueueUsingStack {

  private Stack<Integer> oldStack = new Stack<>();
  private Stack<Integer> newStack = new Stack<>();

  public void add(int val) {
    newStack.push(val);
  }

  public int remove() {
    shiftNewtoOld();
    return oldStack.pop();
  }

  public int peek() {
    shiftNewtoOld();
    return oldStack.peek();
  }

  private void shiftNewtoOld() {
    if (oldStack.isEmpty()) {
      while (!newStack.isEmpty()) {
        oldStack.push(newStack.pop());
      }
    }
  }
}
