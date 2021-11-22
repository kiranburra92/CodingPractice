package com.burra.practice.leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

  Stack<Integer> stack;
  Stack<Integer> min_stack;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new Stack<>();
    min_stack = new Stack<>();
  }

  public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(2147483646);
    obj.push(2147483646);
    obj.push(2147483647);
    System.out.println(obj.top());
    obj.pop();
    System.out.println(obj.getMin());
    obj.pop();
    System.out.println(obj.getMin());
    obj.pop();
    obj.push(2147483647);
    System.out.println(obj.top());
    System.out.println(obj.getMin());
  }

  public void push(int x) {
    stack.push(x);
    if (min_stack.empty()) {
      min_stack.push(x);
    } else if (min_stack.peek() > x) {
      min_stack.push(x);
    } else {
      min_stack.push(min_stack.peek());
    }
  }

  public void pop() {
    stack.pop();
    min_stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min_stack.peek();
  }
}
