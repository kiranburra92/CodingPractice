package com.burra.practice.educative;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

  private static final Queue<Integer> mainQ = new LinkedList<>();
  private static final Queue<Integer> helperQ = new LinkedList<>();

  public static void main(String... args) {
    StackUsingQueues sq = new StackUsingQueues();
    sq.addToStack(1);
    sq.addToStack(3);
    sq.addToStack(5);
    sq.addToStack(7);
    System.out.println(mainQ);
    sq.removeFromStack();
    System.out.println(mainQ);
  }

  public Queue<Integer> addToStack(int x) {
    while (!mainQ.isEmpty()) {
      helperQ.add(mainQ.poll());
    }
    mainQ.add(x);
    while (!helperQ.isEmpty()) {
      mainQ.add(helperQ.poll());
    }
    return mainQ;
  }

  public Queue<Integer> removeFromStack() {
    mainQ.poll();
    return mainQ;
  }
}
