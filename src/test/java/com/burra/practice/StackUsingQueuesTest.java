package com.burra.practice;

import org.junit.Test;

public class StackUsingQueuesTest {

    StackUsingQueues sq = new StackUsingQueues();

    @Test
    public void simpleTest() {
        sq.addToStack(1);
        sq.addToStack(3);
        sq.addToStack(5);

        System.out.println(sq.addToStack(7));

        System.out.println(sq.removeFromStack());
    }
}
