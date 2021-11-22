package com.burra.practice.crackingCodingInterview.stacksAndQueues;

import java.util.Stack;

// Design a stack to return min value in stack with O(1) time complexity
public class MinStack extends Stack<Integer> {

  private Stack<Integer> minimumStack;

  public MinStack() {
    minimumStack = new Stack<>();
  }

  public void push(int item) {
    if (min() >= item) {
      minimumStack.push(item);
    }
    super.push(item);
  }

  public Integer pop() {
    int val = super.pop();
    if (min() == val) {
      minimumStack.pop();
    }
    return val;
  }

  public int min() {
    if (minimumStack.isEmpty()) {
      return Integer.MAX_VALUE;
    }
    return minimumStack.peek();
  }
}
